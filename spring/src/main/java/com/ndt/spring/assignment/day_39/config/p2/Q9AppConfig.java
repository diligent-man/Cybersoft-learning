package com.ndt.spring.assignment.day_39.config.p2;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


import com.ndt.spring.assignment.day_39.service.p2.Q9Service;


@Component("btIoCP2Q9AppConfig")
public class Q9AppConfig {
    @Bean(name = "btIoCP2Q9Service")
    @ConditionalOnProperty(value = "feature")
    public Q9Service getQ9Service() {
        return new Q9Service();
    }


    // Fallback bean creation
    @Bean(name = "btIoCP2Q9Service")
    @ConditionalOnMissingBean(name = "btIoCP2Q9Service")
    @ConditionalOnProperty(value = "feature", havingValue = "false")
    public Q9Service getQ9ServiceFallback() {
        return new Q9Service() {
            @Override
            public String greet() {
                return "Feature is disabled.";
            }
        };
    }
}
