package com.ndt.spring.config.v2;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration(proxyBeanMethods = true)
public class DynamicJpaConfig {
    // private DynamicJpaConfig() {
    //     /* This utility class should not be instantiated */
    // }


    @Bean
    public static BeanDefinitionRegistryPostProcessor dynamicJpaBeanRegistrar(
        ConfigurableEnvironment environment) {
        return new DynamicJpaBeanRegister(environment);
    }
}