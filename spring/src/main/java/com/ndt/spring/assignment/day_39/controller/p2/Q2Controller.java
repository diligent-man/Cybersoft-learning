package com.ndt.spring.assignment.day_39.controller.p2;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.spring.assignment.day_39.service.p2.Q2UserService;


@RestController("btIoCP2Q2Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q2")
public class Q2Controller {
    @Autowired
    @Qualifier("btIoCP2Q2UserService")
    Q2UserService userService;


    @GetMapping("")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(userService.greet());
    }
}
