package com.ndt.spring.assignment.day_39.entity.p2;

import lombok.Data;

import org.springframework.stereotype.Component;


@Data
@Component("btIoCP2Q1StudentComponent")
public class StudentEntity {
    private Integer id;

    private String name;
}
