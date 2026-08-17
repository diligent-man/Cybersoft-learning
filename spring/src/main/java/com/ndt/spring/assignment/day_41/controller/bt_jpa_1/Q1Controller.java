package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q1.*;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.q1.*;

import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.StudentEntity;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1.StudentService;


@RequiredArgsConstructor
@RestController("btJPA1Q1Controller")
@RequestMapping("/assignment/day_41/jpa1/q1/api/students")
public class Q1Controller {
    @Qualifier("btJPA1Q1StudentService")
    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getStudents() {
        StudentsResp resp = StudentsResp
            .builder()
            .students(studentService.getAll())
            .build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(resp)
            .build();
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudent(@Positive @PathVariable Integer id) {
        StudentResp resp = StudentResp
            .builder()
            .student(studentService.getById(id))
            .build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(resp)
            .build();
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse> addStudent(
        @Valid @RequestBody AddStudentReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(studentService.save(req))
                .build()
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(
        @PathVariable Integer id,
        @Valid @RequestBody UpdateStudentReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(studentService.update(id, req))
                .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id) {
        StudentEntity student = studentService.delete(id);

        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("Student with name " + student.getName() + " has been deleted")
                .data(null)
                .build()
        );
    }
}
