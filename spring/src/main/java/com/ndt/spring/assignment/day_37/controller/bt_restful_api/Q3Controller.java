package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q3Service;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ3Controller")
@RequestMapping("/assignment/day_37/restful-api/q3")
public class Q3Controller {
    private final Q3Service q3Service;

    @GetMapping("/calc")
    public Integer calculate(
        @RequestParam(defaultValue = "add") String op,
        @RequestParam(defaultValue = "1") Integer x,
        @RequestParam(defaultValue = "1") Integer y
    ) {
        return q3Service.calculate(x, y, op);
    }
}
