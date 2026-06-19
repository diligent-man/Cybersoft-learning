package com.ndt.spring.assignment.day_39.controller.p1;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_39.entity.p1.Q3Entity;
import com.ndt.spring.assignment.day_39.response.p1.Q3Response;


@RestController("btIoCP1Q3Controller")
@RequestMapping("/assignment/day_39/ioc/p1/q3")
public class Q3Controller {
    @GetMapping("")
    public ResponseEntity<Q3Response> getQ3() {
        Q3Entity obj = new Q3Entity();
        obj.setId(1);
        obj.setName("Bình");

        Q3Response response = new Q3Response();
        response.setUser(obj);

        return ResponseEntity.ok(response);
    }
}
