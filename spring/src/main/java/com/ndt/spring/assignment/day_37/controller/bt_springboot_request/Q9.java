package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.ndt.spring.assignment.day_37.request.bt_springboot_request.Q9Request;


@Controller("btSpringbootRequestQ9")
@RequestMapping("/assignment/day_37/bt-springboot-request/q9")
public class Q9 {
    @PutMapping("/users/{id}")
    public ResponseEntity<Map<String, Object>> getOrder(
        @PathVariable Integer id,
        @RequestBody Q9Request body
    ) {
        Map<String, Object> result = new HashMap<>();

        result.put("id", id);
        result.put("update_info", body);

        return ResponseEntity.ok(result);
    }
}
