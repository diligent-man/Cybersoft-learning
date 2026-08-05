package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.CourseEntity;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2.CourseService;


@RequiredArgsConstructor
@RestController("btJPA1Q2Controller")
@RequestMapping("/assignment/day_41/jpa1/q2")
public class Q2Controller {
    @Qualifier("btJPA1Q2CourseService")
    private final CourseService courseService;


    @GetMapping("")
    public ResponseEntity<List<CourseEntity>> get() {
        return ResponseEntity.ok(courseService.getAll());
    }
}
