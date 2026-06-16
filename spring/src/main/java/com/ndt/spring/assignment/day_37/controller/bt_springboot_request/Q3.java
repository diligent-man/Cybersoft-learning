package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller("btSpringbootRequestQ3")
@RequestMapping("/assignment/day_37/bt-springboot-request/q3")
public class Q3 {
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
