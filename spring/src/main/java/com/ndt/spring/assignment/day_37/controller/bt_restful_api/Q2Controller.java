package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q2Service;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ2Controller")
@RequestMapping("/assignment/day_37/restful-api/q2")
public class Q2Controller {
    private final Q2Service q2Service;


    @GetMapping("/greet")
    public String greet(
        @RequestParam(defaultValue = "Alice") String name
    ) {
        return q2Service.greet(name);
    }
}
