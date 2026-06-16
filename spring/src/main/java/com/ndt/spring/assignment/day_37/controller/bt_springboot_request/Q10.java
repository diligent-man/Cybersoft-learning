package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller("btSpringbootRequestQ10")
@RequestMapping("/assignment/day_37/bt-springboot-request/q10")
public class Q10 {
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getOrder (
    ) {

        return ResponseEntity.ok(null);
    }
}
