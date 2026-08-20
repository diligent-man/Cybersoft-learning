package com.ndt.spring.config.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;


@Configuration
public class DynamicJpaConfig {

    @Bean
    public static BeanDefinitionRegistryPostProcessor dynamicJpaBeanRegistrer(
        ConfigurableEnvironment environment
    ) {
        return new DynamicJpaBeanRegister(environment);
    }
}
