package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q6.EmployeeService;


@RequiredArgsConstructor
@RestController("btJPA2Q6Controller")
@RequestMapping("/assignment/day_41/jpa2/q6/api/employees")
public class Q6Controller {
    @Qualifier("btJPA2Q6EmployeeService")
    private final EmployeeService employeeService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getEmployees(
        @PageableDefault(
            size = 5,
            sort = "id",
            direction = Sort.Direction.DESC
        )
        Pageable pageable
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(employeeService.getAll(pageable))
                .build()
        );
    }
}
