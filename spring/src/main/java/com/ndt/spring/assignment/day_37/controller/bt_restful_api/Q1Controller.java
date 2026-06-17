package com.ndt.spring.assignment.day_37.controller.bt_restful_api;


import org.springframework.web.bind.annotation.*;


@RestController("btRestfullAPIQ1Controller")
@RequestMapping("/assignment/day_37/restful-api/q1")
public class Q1Controller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
