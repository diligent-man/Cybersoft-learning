package com.ndt.spring.assignment.day_39.response.p1;

import java.util.List;
import java.util.Map;

import lombok.Data;

import com.ndt.spring.assignment.day_39.entity.p1.Q5Entity;


@Data
public class Q5Response {
    Map<String, List<Q5Entity>> objMap;
}
