package com.ndt.spring.assignment.day_37.service.bt_restful_api;


import org.springframework.stereotype.Service;


@Service("btRestfullAPIQ2Service")
public class Q2Service {
    public String greet(String name) {
         return String.format("Hello %s!", name);
    }
}
