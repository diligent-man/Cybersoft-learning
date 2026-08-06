package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q1.StudentService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q1.StudentsResp;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q1.StudentEntity;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.AddStudentRequest;


@RequiredArgsConstructor
@RestController("btJPA2Q1Controller")
@RequestMapping("/assignment/day_41/jpa2/q1/api/students")
public class Q1Controller {
    @Qualifier("btJPA2Q1StudentService")
    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getStudents() {
        StudentsResp q1StudentsResp = StudentsResp.builder().students(studentService.getAll()).build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(q1StudentsResp)
            .build();
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse> addStudent(@Valid @RequestBody AddStudentRequest request) {
        StudentEntity saved = studentService.save(request);

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(saved)
            .build();
        return ResponseEntity.ok(apiResponse);
    }
}
