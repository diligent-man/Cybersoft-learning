package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ4")
@RequestMapping("/assignment/day_37/bt-springboot-request/q4")
public class Q4 {
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchByKeywordWithPage(
        @RequestParam(defaultValue = "spring") String keyword,
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "10") Integer size
    ) {
        Map<String, Object> orderObj = new HashMap<>();

        orderObj.put("keyword", keyword);
        orderObj.put("page", page);
        orderObj.put("size", size);

        return ResponseEntity.ok(orderObj);
    }
}
