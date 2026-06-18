package com.ndt.spring.assignment.day_39.response.p1;

import java.util.Map;

import lombok.Data;

import com.ndt.spring.assignment.day_39.entity.p1.Q3Entity;


@Data
public class Q3Response {
    Map<String, Q3Entity> objMap;
}
