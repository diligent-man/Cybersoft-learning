package com.ndt.spring.assignment.day_37.config;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q6Service;


@Component("btRestfullAPIQ6AppConfig")
public class Q2AppConfig {
    @Bean(name = "btRestfullAPIQ6GreetingService")
    public Q6Service getGreetingService() {
        return new Q6Service();
    }
}
