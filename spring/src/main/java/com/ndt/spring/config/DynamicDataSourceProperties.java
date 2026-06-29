package com.ndt.spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Setter
@Getter
@ConfigurationProperties(prefix = "spring")
public class DynamicDataSourceProperties {
    private Map<String, DbConfig> datasources = new HashMap<>();


    @Setter
    @Getter
    public static class DbConfig {
        private String beanName;
        private String url;
        private String username;
        private String password;
    }
}
