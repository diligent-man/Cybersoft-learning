package com.ndt.spring.assignment.day_39.controller.p2;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;


@RestController("btIoCP2Q6Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q6")
public class Q6Controller {
    @Value("${app.roles:ADMIN,USER,GUEST}")
    List<String> roleLst;


    @GetMapping("")
    public ResponseEntity<List<String>> getRoles() {
        return ResponseEntity.ok(roleLst);
    }
}
