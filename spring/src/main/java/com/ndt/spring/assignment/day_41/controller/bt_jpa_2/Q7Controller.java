package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q7.UserEntity;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q7.AddUserReq;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q7.UserService;


@RequiredArgsConstructor
@RestController("btJPA2Q7Controller")
@RequestMapping("/assignment/day_41/jpa2/q7/api/users")
public class Q7Controller {
    @Qualifier("btJPA2Q7UserService")
    private final UserService userService;


    @PostMapping("")
    public ResponseEntity<ApiResponse> addUser(
        @Valid @RequestBody AddUserReq req
    ) {
        UserEntity user = userService.addUser(req);

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(user)
            .build();
        return ResponseEntity.ok(apiResponse);
    }
}
