package com.ndt.spring.assignment.day_39.controller.p2;


import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("btIoCP2Q4Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q4")
public class Q4Controller {
    @Value("${app.name:DemoApp}")
    String appName;


    @GetMapping("")
    public ResponseEntity<String> getAppName() {
        return ResponseEntity.ok(appName);
    }
}
