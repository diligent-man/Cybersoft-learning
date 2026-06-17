package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.ndt.spring.assignment.day_37.request.bt_springboot_request.Q2Request;


@Controller("btSpringbootRequestQ2Controller")
@RequestMapping("/assignment/day_37/bt-springboot-request/q2")
public class Q2Controller {
    @PostMapping("/comments")
    public ResponseEntity<Map<String, Object>> updatePostComment(
        @RequestParam(defaultValue = "5") Integer postId,
        @RequestBody Q2Request body
    ) {
        Map<String, Object> result = new HashMap<>();

        result.put("postId", postId);
        result.put("body", body);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
