package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5.StudentService;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q5.AddStudentReq;


@RequiredArgsConstructor
@RestController("btJPA2Q5StudentController")
@RequestMapping("/assignment/day_41/jpa2/q5/api/students")
public class Q5StudentController {
    @Qualifier("btJPA2Q5StudentService")
    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@Valid @RequestBody AddStudentReq req) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(studentService.add(req))
                .build()
        );
    }
}
