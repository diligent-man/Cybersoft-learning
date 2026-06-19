package com.ndt.spring.assignment.day_39.config.p2;

import org.springframework.context.annotation.Bean;


import com.ndt.spring.assignment.day_39.service.p2.Q2UserService;
import org.springframework.stereotype.Component;


@Component("btIoCP2Q2AppConfig")
public class Q2AppConfig {
    @Bean(name = "btIoCP2Q2UserService")
    public Q2UserService getUserService() {
        return new Q2UserService();
    }
}
