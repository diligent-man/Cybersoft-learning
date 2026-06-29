package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@RequiredArgsConstructor
@RestController("btJpa1Q1Controller")
@RequestMapping("/assignment/day_41/jpa1/q1")
public class Q1Controller {
    @Qualifier("routingDataSource")
    private final DataSource routingDataSource;
}
