package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q6Service;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ6Controller")
@RequestMapping("/assignment/day_37/restful-api/q6")
public class Q6Controller {
    @Qualifier("btRestfullAPIQ6GreetingService")
    private final Q6Service greetingService;


    @GetMapping("")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok(greetingService.greet());
    }
}
