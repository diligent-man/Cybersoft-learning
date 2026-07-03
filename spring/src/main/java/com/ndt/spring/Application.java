package com.ndt.spring;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


import com.ndt.spring.config.v1.WebConfig;
import com.ndt.spring.config.v1.DynamicSourceConfig;
import com.ndt.spring.config.v1.DynamicDataSourceProperties;


@SpringBootApplication(
    // exclude = {
    //     DataSourceAutoConfiguration.class
    // }
)
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = {
            DynamicDataSourceProperties.class,
            DynamicSourceConfig.class,
            WebConfig.class,
        }
    )
)
@ConfigurationPropertiesScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
