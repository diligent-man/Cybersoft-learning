package com.ndt.spring.assignment.day_39.controller.p2;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.spring.assignment.day_39.service.p2.Q3Service;


@RestController("btIoCP2Q3Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q3")
public class Q3Controller {
    @Autowired
    @Qualifier("btIocP2Q3Service")
    Q3Service service;


    @GetMapping("")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(service.greet());
    }
}
