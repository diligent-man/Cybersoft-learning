package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;


import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentResp;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1.StudentService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentListResp;


@RequiredArgsConstructor
@RestController("btJpa1Q1Controller")
@RequestMapping("/assignment/day_41/jpa1/q1/api/students")
public class Q1Controller {
    @Qualifier("btJpa1Q1StudentService")
    private final StudentService studentService;


    @GetMapping("")
    public ResponseEntity<Q1StudentListResp> getStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Q1StudentResp> getStudent(@PathVariable Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(studentService.getById(id));
    }
}
