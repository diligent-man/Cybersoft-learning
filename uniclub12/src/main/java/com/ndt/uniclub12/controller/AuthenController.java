package com.ndt.uniclub12.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.uniclub12.enumeric.AuthenError;

import com.ndt.uniclub12.service.AuthenService;
import com.ndt.uniclub12.payload.request.SignInRequest;

import com.ndt.uniclub12.payload.response.BaseResponse;
import com.ndt.uniclub12.payload.response.SignInResponse;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenController {
    private final AuthenService authenService;


    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
        @RequestBody SignInRequest request
    ) {
        String token = authenService.doLogin(request);

        BaseResponse baseResponse = SignInResponse.builder()
            .code(200)
            .message(AuthenError.A00.toString())
            .data(token)
            .build();
        return ResponseEntity.ok(baseResponse);
    }
}
