package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller("btSpringbootRequestQ5Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q5")
public class Q5Controller {
    @GetMapping("/tags")
    public ResponseEntity<Map<String, Object>> getOrder(
        @RequestParam(defaultValue = "java,spring,boot") List<String> tags
    ) {
        Map<String, Object> result = new HashMap<>();
        result.put("tags", tags);
        return ResponseEntity.ok(result);
    }
}
