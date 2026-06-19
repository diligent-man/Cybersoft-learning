package com.ndt.spring.assignment.day_39.controller.p1;

import java.util.List;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


@RestController("btIoCP1Q2Controller")
@RequestMapping("/assignment/day_39/ioc/p1/q2")
public class Q2Controller {
    @GetMapping("")
    public ResponseEntity<List<String>> getQ2() {
        List<String> lst = new ArrayList<>(
            List.of("java", "spring", "json")
        );
        return ResponseEntity.ok(lst);
    }
}
