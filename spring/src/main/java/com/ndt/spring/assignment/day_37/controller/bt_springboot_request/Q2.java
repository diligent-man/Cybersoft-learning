package com.ndt.spring.assignment.day_37.controller.bt_springboot_request;


import com.ndt.spring.assignment.day_37.request.bt_springboot_request.Q2Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller("btSpringbootRequestQ2")
@RequestMapping("/assignment/day_37/bt-springboot-request/q2")
public class Q2 {
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
