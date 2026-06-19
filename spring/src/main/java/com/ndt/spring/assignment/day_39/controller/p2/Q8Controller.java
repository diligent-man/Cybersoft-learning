package com.ndt.spring.assignment.day_39.controller.p2;


import com.ndt.spring.assignment.day_39.service.p2.Q8Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;


@RestController("btIoCP2Q8Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q8")
public class Q8Controller {
    @GetMapping("")
    public ResponseEntity<Map<String, String>> checkBeanScopeInstance(
        @Qualifier("btIoCP2Q8Service") Q8Service service
    ){
        Map<String, String> result = new HashMap<>();

        result.put("instance_address", String.valueOf(System.identityHashCode(service)));
        return ResponseEntity.ok(result);
    }

}
