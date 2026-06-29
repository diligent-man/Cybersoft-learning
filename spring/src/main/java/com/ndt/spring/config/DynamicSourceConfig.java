package com.ndt.spring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicSourceConfig {
    @Bean("routingDataSource")
    @Primary
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
