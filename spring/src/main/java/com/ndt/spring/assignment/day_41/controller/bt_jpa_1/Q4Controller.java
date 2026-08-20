package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import jakarta.validation.constraints.Positive;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q4.RegistrationService;


@RequiredArgsConstructor
@RestController("btJPA1Q4Controller")
@RequestMapping("/assignment/day_41/jpa1/q4/api")
public class Q4Controller {
    @Qualifier("btJPA1Q4RegistrationService")
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


    @PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<ApiResponse> registerCourses(
        @Positive @PathVariable Integer studentId,
        @Positive @PathVariable Integer courseId
    ) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(registrationService.enrollCourse(studentId, courseId))
                .build()
        );
    }


    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<ApiResponse> withrawCourse(
        @Positive @PathVariable Integer studentId,
        @Positive @PathVariable Integer courseId
    ) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .status("success")
                .data(registrationService.unenrollCourse(studentId, courseId))
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
