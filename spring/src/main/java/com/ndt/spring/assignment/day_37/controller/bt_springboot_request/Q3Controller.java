package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.Map;
import java.util.HashMap;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ3Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q3")
public class Q3Controller {
    @GetMapping("/users/{id}")
    public ResponseEntity<Map<String, Object>> getUserId(
        @PathVariable String id,
        @RequestHeader HttpHeaders headers
    ) {
        String xClientVersion = headers.getFirst("X-Client-Version");

        Map<String, Object> result = new HashMap<>();

        result.put("userId", id);
        result.put("X-Client-Version", xClientVersion);

        return ResponseEntity.ok().body(result);
    }
}
