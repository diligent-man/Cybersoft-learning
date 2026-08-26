package com.ndt.uniclub12.controller;

import java.util.Map;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.uniclub12.service.AuthenService;
import com.ndt.uniclub12.exception.AuthenErrorMsg;

import com.ndt.uniclub12.payload.request.SignInRequest;

import com.ndt.uniclub12.payload.response.ApiResponse;
import com.ndt.uniclub12.payload.response.SignInResponse;


@CrossOrigin  // allow all domains
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenController {
    private final AuthenService authenService;


    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponse> signIn(
        @RequestBody SignInRequest request
    ) {
        String token = authenService.doLogin(request);
        return ResponseEntity.ok(
            SignInResponse.builder()
                .code("200")
                .message(AuthenErrorMsg.LOGIN_SUCCESS.getErrorMsg())
                .data(Map.of("token", token))
                .build()
        );
    }
}
