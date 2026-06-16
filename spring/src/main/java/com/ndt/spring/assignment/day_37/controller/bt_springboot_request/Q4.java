package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller("btSpringbootRequestQ4")
@RequestMapping("/assignment/day_37/bt-springboot-request/q4")
public class Q4 {
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchByKeywordWithPage (
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
