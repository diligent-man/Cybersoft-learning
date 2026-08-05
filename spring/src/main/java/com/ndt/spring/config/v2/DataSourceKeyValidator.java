package com.ndt.spring.config.v2;

import java.util.Map;

import javax.sql.DataSource;

import jakarta.annotation.PostConstruct;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataSourceKeyValidator {
    private final Map<String, DataSource> dataSourceBeans;


    @PostConstruct
    public void validate() {
        for (DatabaseType type : DatabaseType.values()) {
            String expectedBean = type.getName();
            if (!dataSourceBeans.containsKey(expectedBean)) {
                throw new IllegalStateException(
                    String.format("""
                        No DataSource bean registered for DatabaseType. %s (expected bean name: %s)
                        """, type.name(), expectedBean
                    )
                );
            }
        }
    }
}
