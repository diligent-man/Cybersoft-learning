package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q1.StudentRepo;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1.StudentService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentResp;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentsResp;


@RequiredArgsConstructor
@RestController("btJpa1Q1Controller")
@RequestMapping("/assignment/day_41/jpa1/q1/api/students")
public class Q1Controller {
    @Qualifier("btJPA1Q1StudentService")
    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getStudents() {
        Q1StudentsResp q1StudentsResp = Q1StudentsResp.builder().students(studentService.getAll()).build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(q1StudentsResp)
            .build();
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudent(@PathVariable Integer id) {
        Q1StudentResp q1StudentResp = Q1StudentResp.builder().student(studentService.getById(id)).build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(q1StudentResp)
            .build();
        return ResponseEntity.ok(apiResponse);
    }
}
