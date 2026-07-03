package com.ndt.spring.config.v2;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DatabaseType databaseType = DataSourceContextHolder.get();
        return databaseType != null ? databaseType.getName() : DatabaseType.DEFAULT.getName();
    }
}