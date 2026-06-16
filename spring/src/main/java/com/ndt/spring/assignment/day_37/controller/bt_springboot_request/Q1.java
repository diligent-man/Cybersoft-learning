package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller("btSpringbootRequestQ1")
@RequestMapping("/assignment/day_37/bt-springboot-request/q1")
public class Q1 {
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder (
        @PathVariable Integer orderId,
        @RequestParam(defaultValue = "VND") String currency
    ) {
        Map<String, Object> orderObj = new HashMap<>();

        orderObj.put("orderId", orderId);
        orderObj.put("currency", currency);

        return ResponseEntity.ok(orderObj);
    }
}
