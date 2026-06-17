package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ1Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q1")
public class Q1Controller {
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(
        @PathVariable Integer orderId,
        @RequestParam(defaultValue = "VND") String currency
    ) {
        Map<String, Object> orderObj = new HashMap<>();

        orderObj.put("orderId", orderId);
        orderObj.put("currency", currency);

        return ResponseEntity.ok(orderObj);
    }
}
