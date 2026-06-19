package com.ndt.spring.assignment.day_39.controller.p2;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;


@RestController("btIoCP2Q7Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q7")
public class Q7Controller {
    @Value("${app.port:8080}")
    Integer appPort;


    @GetMapping("")
    public ResponseEntity<Integer> getAppPort() {
        return ResponseEntity.ok(appPort);
    }
}
