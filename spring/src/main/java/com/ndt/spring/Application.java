package com.ndt.spring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.data.jpa.autoconfigure.DataJpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;


import com.ndt.spring.config.v1.WebConfig;
import com.ndt.spring.config.v1.DynamicSourceConfig;
import com.ndt.spring.config.v1.DynamicDataSourceProperties;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication(
    exclude = {
        // HibernateJpaAutoConfiguration.class,
        // DataSourceAutoConfiguration.class,
        // DataSourceTransactionManagerAutoConfiguration.class,
        // DataJpaRepositoriesAutoConfiguration.class
    }
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
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@ConfigurationPropertiesScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
