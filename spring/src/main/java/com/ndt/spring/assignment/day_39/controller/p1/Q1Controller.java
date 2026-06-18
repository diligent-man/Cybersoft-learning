package com.ndt.spring.assignment.day_39.controller.p1;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_39.entity.p1.Q1Entity;


@RestController("btIoCP1Q1Controller")
@RequestMapping("/assignment/day_39/ioc/p1/q1")
public class Q1Controller {
    @GetMapping("")
    public ResponseEntity<Q1Entity> getQ1() {
        Q1Entity q1Entity = new Q1Entity();

        q1Entity.setName("An");
        q1Entity.setAge(20);

        return ResponseEntity.ok(q1Entity);
    }
}
