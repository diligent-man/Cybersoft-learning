package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q8.OrderService;


@RequiredArgsConstructor
@RestController("btJPA2Q8Controller")
@RequestMapping("/assignment/day_41/jpa2/q8/api/orders")
public class Q8Controller {
    @Qualifier("btJPA2Q8OrderService")
    private final OrderService orderService;


    @GetMapping("/top")
    public ResponseEntity<ApiResponse> getTopFiveOrdersByTotalAmount() {
        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(orderService.findTop5OrdersByTotalAmount())
            .build();
        return ResponseEntity.ok(apiResponse);
    }
}
