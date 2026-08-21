package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q5.*;

import com.ndt.spring.payload.resp.ApiResponse;
import com.ndt.spring.payload.resp.PageResponse;

import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q5.StudentSearchReq;


@Controller("btJPA1Q5Controller")
@RequestMapping("/assignment/day_41/jpa1/q5/api")
@RequiredArgsConstructor
public class Q5Controller {
    @Qualifier("btJPA1Q5StudentService")
    private final StudentService studentRepo;

    @Qualifier("btJPA1Q5CourseService")
    private final CourseService courseService;


    @GetMapping("/students/search")
    public ResponseEntity<ApiResponse> searchStudent(
        @Valid @ModelAttribute StudentSearchReq req,
        @PageableDefault(size = 5) Pageable pageable
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(PageResponse.from(studentRepo.search(req, pageable)))
                .build()
        );
    }


    @GetMapping("/courses")
    public ResponseEntity<ApiResponse> getCourses(
        @PageableDefault(
            sort = "duration",
            size = 5,
            direction = Sort.Direction.DESC
        ) Pageable pageable
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(PageResponse.from(courseService.getAll(pageable)))
                .build()
        );
    }
}
