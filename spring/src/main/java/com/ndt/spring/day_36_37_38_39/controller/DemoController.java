package com.ndt.spring.day_36_37_38_39.controller;

import com.ndt.spring.day_36_37_38_39.dto.BaiVietDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = {"/day_36_37_38_39/demo"})
public class DemoController {
    @Autowired
    private BaiVietDTO baiVietDTO;


    @GetMapping("")
    public String hello() {
        return "Hello Spring boot 4";
    }


    @GetMapping("/hello")
    public String helloAnhEm() {
        return "Hello Anh Em";
    }


    @GetMapping("/baiviet-bean")
    public BaiVietDTO getBaiVietDTO() {
        return baiVietDTO;
    }
}
