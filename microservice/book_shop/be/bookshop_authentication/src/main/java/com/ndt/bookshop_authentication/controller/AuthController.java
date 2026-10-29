package com.ndt.bookshop_authentication.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.ndt.bookshop_authentication.payload.req.AuthReq;
import com.ndt.bookshop_authentication.payload.resp.ApiResp;
import com.ndt.bookshop_authentication.service.contract.AuthService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
        @Validated @RequestBody AuthReq authReq
    ) {
        String token = authService.signIn(authReq);
        return ResponseEntity.ok(ApiResp
            .builder()
            .status(200)
            .message("Sign in successful")
            .data(token)
        );
    }
}
