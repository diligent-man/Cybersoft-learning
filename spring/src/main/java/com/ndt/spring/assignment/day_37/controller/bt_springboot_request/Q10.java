package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.Map;
import java.util.HashMap;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ10")
@RequestMapping("/assignment/day_37/bt-springboot-request/q10")
public class Q10 {
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Object>> getOrder(
        @PathVariable Long id,
        @RequestHeader("Authorization") String authorization
    ) {
        if (authorization == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        String token = authorization.replace("Bearer ", "");

        System.out.println("ID: " + id);
        System.out.println("Token: " + token);

        Map<String, Object> result = new HashMap<>();

        result.put("id", id);
        result.put("Bearer", token);

        return ResponseEntity.ok(result);
    }
}
