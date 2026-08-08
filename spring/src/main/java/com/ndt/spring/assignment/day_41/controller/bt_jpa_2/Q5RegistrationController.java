package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.constraints.Positive;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.CourseDTO;
import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.RegistrationDTO;

import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q5.CoursesResp;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5.RegistrationService;


@RequiredArgsConstructor
@RestController("btJPA2Q5RegistrationController")
@RequestMapping("/assignment/day_41/jpa2/q5/api/students")
public class Q5RegistrationController {
    @Qualifier("btJPA2Q5RegistrationService")
    private final RegistrationService registrationService;


    @GetMapping("/{id}/courses")
    public ResponseEntity<ApiResponse> getCoursesByStudent(
        @PathVariable
        @Positive
        Integer id
    ) {
        CoursesResp courses = CoursesResp.builder()
            .courses(registrationService
                .getCoursesByStudent(id)
                .parallelStream()
                .map(CourseDTO::fromEntity)
                .toList()
            )
            .build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(courses)
                .build()
        );
    }


    @PostMapping("/{id}/courses/{courseId}")
    public ResponseEntity<ApiResponse> registerCourse(
        @PathVariable @Positive Integer id,
        @PathVariable @Positive Integer courseId
    ) {
        RegistrationDTO registration = registrationService.registerCourse(id, courseId);
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(registration)
                .build()
        );
    }
}
