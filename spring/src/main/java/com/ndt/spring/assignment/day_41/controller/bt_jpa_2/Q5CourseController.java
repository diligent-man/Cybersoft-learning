package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5.CourseService;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q5.AddCourseReq;


@RequiredArgsConstructor
@RestController("btJPA2Q5CourseController")
@RequestMapping("/assignment/day_41/jpa2/q5/api/courses")
public class Q5CourseController {
    @Qualifier("btJPA2Q5CourseService")
    private final CourseService courseService;


    @PostMapping
    public ResponseEntity<ApiResponse> addCourse(@Valid @RequestBody AddCourseReq req) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(courseService.addCourse(req))
                .build()
        );
    }
}
