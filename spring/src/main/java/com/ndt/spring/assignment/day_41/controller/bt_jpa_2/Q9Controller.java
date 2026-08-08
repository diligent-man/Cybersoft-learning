package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q9.CustomerService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q9.CustomerResp;


@RequiredArgsConstructor
@RestController("btJPA2Q9Controller")
@RequestMapping("/assignment/day_41/jpa2/q9/api/customers")
public class Q9Controller {
    @Qualifier("btJPA2Q9CustomerService")
    private final CustomerService customerService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getStudents() {
        CustomerResp customers = CustomerResp.builder().customers(customerService.getAll()).build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(customers)
                .build()
        );
    }
}
