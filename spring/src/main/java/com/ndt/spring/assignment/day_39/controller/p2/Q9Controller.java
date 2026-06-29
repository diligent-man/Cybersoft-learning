package com.ndt.spring.assignment.day_39.controller.p2;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_39.service.p2.Q9Service;


@RequiredArgsConstructor
@RestController("btIoCP2Q9Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q9")
public class Q9Controller {
    @Qualifier("btIoCP2Q9Service")
    private final Q9Service q9Service;


    @GetMapping("")
    public ResponseEntity<String> getBeanOnCondition() {
        return ResponseEntity.ok(q9Service.greet());
    }

}
