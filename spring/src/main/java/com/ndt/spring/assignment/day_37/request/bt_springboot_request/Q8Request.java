package com.ndt.spring.assignment.day_37.request.bt_springboot_request;

import java.util.List;

import lombok.Data;


@Data
public class Q8Request {
    List<String> titles;

    List<String> descriptions;

    List<List<String>> tags;
}
