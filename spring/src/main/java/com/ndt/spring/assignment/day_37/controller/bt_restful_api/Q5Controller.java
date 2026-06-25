package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import java.util.*;


import lombok.RequiredArgsConstructor;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q5Service;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q5StudentEntity;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ5Controller")
@RequestMapping("/assignment/day_37/restful-api/q5")
public class Q5Controller {
    private final Q5Service q5Service;


    @GetMapping("/students/{id}")
    public ResponseEntity<Q5StudentEntity> getStudent(@PathVariable Integer id) {
        return q5Service.getStudent(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping("/students")
    public ResponseEntity<Map<String, Object>> addStudent(
        @RequestBody Q5StudentEntity body
    ) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        Map<String, Object> result = new HashMap<>();

        if (q5Service.addStudent(body)) {
            result.put("added_obj", body);
            statusCode = HttpStatus.OK;
        }

        result.put("num_obj", q5Service.getStudents().size());
        return ResponseEntity.status(statusCode).body(result);
    }
}
