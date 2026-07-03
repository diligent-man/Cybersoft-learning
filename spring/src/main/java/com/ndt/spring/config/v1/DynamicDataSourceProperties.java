package com.ndt.spring.config.v1;

import java.util.Map;
import java.util.HashMap;


import lombok.Getter;
import lombok.Setter;


import org.springframework.boot.context.properties.ConfigurationProperties;


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
