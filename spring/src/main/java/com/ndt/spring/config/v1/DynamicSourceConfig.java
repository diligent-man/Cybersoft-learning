package com.ndt.spring.config.v1;

import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;


import com.zaxxer.hikari.HikariDataSource;


import org.springframework.context.annotation.*;


@Configuration
public class DynamicSourceConfig {
    @Primary
    @Bean("routingDataSource")
    public DataSource routingDataSource(
        DynamicDataSourceProperties properties
    ) {
        RoutingDataSource router = new RoutingDataSource();

        Map<Object, Object> targetDataSources = new HashMap<>();

        properties.getDatasources().forEach((key, config) -> {

            HikariDataSource ds = new HikariDataSource();

            ds.setJdbcUrl(config.getUrl());
            ds.setUsername(config.getUsername());
            ds.setPassword(config.getPassword());
            targetDataSources.put(key, ds);

        });

        router.setTargetDataSources(targetDataSources);
        router.setDefaultTargetDataSource(targetDataSources.get("default"));
        router.afterPropertiesSet();
        return router;
    }
}
