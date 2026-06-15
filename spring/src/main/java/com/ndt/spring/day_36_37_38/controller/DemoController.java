package com.ndt.spring.day_36_37_38.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    Annotation that defines what kind of data to return
        @Controller: returns HTML page

        @RestController: returns text


    Annotation that define routing path
        @RequestMapping
 */
@RestController(value = "demoController")
@RequestMapping(value = {"/day_36_37_38/demo"})
public class DemoController {
    @GetMapping("")
    public String hello(){
        return "Hello Spring boot 4";
    }

    @GetMapping("/hello")
    public String helloAnhEm(){
        return "Hello Anh Em";
    }
}
