package com.ndt.spring.config.v2;

import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;


import org.springframework.context.annotation.*;


@Configuration
public class DynamicSourceConfig {
    @Primary
    @Bean("routingDataSource")
    public DataSource routingDataSource(
        Map<String, DataSource> dataSourceBeans
    ) {
        RoutingDataSource router = new RoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(dataSourceBeans);

        router.setTargetDataSources(targetDataSources);
        router.setDefaultTargetDataSource(targetDataSources.get("default"));
        router.afterPropertiesSet();
        return router;
    }
}
