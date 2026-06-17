package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ7Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q7")
public class Q7Controller {
    @PostMapping("/login-form")
    public ResponseEntity<Map<String, Object>> doLogin(
        @RequestHeader(value = "Content-Type", defaultValue = "application/x-www-form-urlencoded") String contentType,
        @RequestParam(defaultValue = "admin") String username,
        @RequestParam(defaultValue = "123") String password
    ) {
        Map<String, Object> result = new HashMap<>();

        result.put("username", username);
        result.put("password", password);
        result.put("Content-Type", contentType);

        return ResponseEntity.ok(result);
    }
}
