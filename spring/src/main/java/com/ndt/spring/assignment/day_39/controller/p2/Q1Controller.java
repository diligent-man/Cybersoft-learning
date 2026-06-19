package com.ndt.spring.assignment.day_39.controller.p2;


import com.ndt.spring.assignment.day_39.entity.p2.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("btIoCP2Q1Controller")
@RequestMapping("/assignment/day_39/ioc/p2/q1")
public class Q1Controller {
    @Autowired
    @Qualifier("btIoCP2Q1StudentComponent")
    private StudentEntity student;


    @GetMapping("")
    public ResponseEntity<StudentEntity> getStudent() {
        StudentEntity obj = new StudentEntity();

        obj.setId(1);
        obj.setName("Nguyen Van A");

        return ResponseEntity.ok(obj);
    }
}
