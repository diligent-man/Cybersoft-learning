package com.ndt.spring.config.v2;

import java.util.*;


import lombok.Getter;
import lombok.Setter;


import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Setter
@Getter
@ConfigurationProperties(prefix = "spring")
public class DynamicDataSourceProperties {
    private Map<String, DbConfig> datasources = new HashMap<>();


    @Setter
    @Getter
    @ToString
    public static class DbConfig {
        private String url;

        private String username;

        private String password;

        private Map<String, String> jpa = new LinkedHashMap<>();
    }
}
