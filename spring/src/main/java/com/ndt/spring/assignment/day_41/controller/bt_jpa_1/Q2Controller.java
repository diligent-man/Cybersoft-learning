package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2.StudentService;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2.CourseService;


@RequiredArgsConstructor
@RestController("btJPA1Q2Controller")
@RequestMapping("/assignment/day_41/jpa1/q2/api")
public class Q2Controller {
    @Qualifier("btJPA1Q2CourseService")
    private final CourseService courseService;

    @Qualifier("btJPA1Q2StudentService")
    private final StudentService studentService;


    @GetMapping("/courses")
    public ResponseEntity<ApiResponse> searchCourses(
        @Positive
        @Digits(integer = 2, fraction = 1)
        @RequestParam
        BigDecimal durationGreaterThan
    ) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("sucess")
                .data(Map.of("courses", courseService.search(durationGreaterThan)))
                .build()
        );
    }


    @GetMapping("/courses/count")
    public ResponseEntity<ApiResponse> countCourses() {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(Map.of("num_courses", courseService.getAll().size()))
                .build()
        );
    }


    @GetMapping("/students")
    public ResponseEntity<ApiResponse> searchStudents(
        @NotBlank
        @Size(min = 1, max = 200)
        @RequestParam String name
    ) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(Map.of("students", studentService.search(name)))
                .build()
        );
    }
}
