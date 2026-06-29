package com.ndt.spring.assignment.day_39.controller.p2;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_39.config.p2.Q10DatabaseConfig;


@RequiredArgsConstructor
@RestController("btIoCP2Q10Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q10")
public class Q10Controller {
    @Qualifier("btIoCP2Q10DatabaseConfig")
    private final Q10DatabaseConfig dbConfig;


    @GetMapping("")
    public ResponseEntity<Q10DatabaseConfig> readDbConfig() {
        return ResponseEntity.ok(dbConfig);
    }
}
