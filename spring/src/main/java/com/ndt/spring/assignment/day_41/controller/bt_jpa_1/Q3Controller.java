package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;


import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q3.*;

import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q3.RegistrationService;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q3.RegisterCourseReq;


@RequiredArgsConstructor
@RestController("btJPA1Q3Controller")
@RequestMapping("/assignment/day_41/jpa1/q3/api")
public class Q3Controller {
    @Qualifier("btJPA1Q3RegistrationService")
    private final RegistrationService registrationService;


    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<ApiResponse> getCoursesByStudent(@PathVariable Integer studentId) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(registrationService.getCoursesByStudent(studentId))
                .build()
        );
    }


    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<ApiResponse> registerCourses(
        @PathVariable Integer studentId,
        @Valid @RequestBody RegisterCourseReq request) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(registrationService.registerCourses(studentId, request))
                .build()
        );
    }


    @GetMapping("/courses/{courseId}/students")
    public ResponseEntity<ApiResponse> getStudentsByCourse(@PathVariable Integer courseId) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(registrationService.getStudentsByCourse(courseId))
                .build()
        );
    }
}
