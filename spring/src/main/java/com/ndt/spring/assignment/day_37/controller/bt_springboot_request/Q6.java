package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.Map;
import java.util.HashMap;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ6")
@RequestMapping("/assignment/day_37/bt-springboot-request/q6")
public class Q6 {
    @GetMapping("/filters")
    public ResponseEntity<Map<String, String>> getFilters(
        @RequestParam Map<String, String> filters
    ) {
        Map<String, String> result = new HashMap<>();

        result.put("color", filters.getOrDefault("color", "red"));
        result.put("size", filters.getOrDefault("size", "M"));
        result.put("brand", filters.getOrDefault("brand", "Nike"));

        return ResponseEntity.ok(result);
    }
}
