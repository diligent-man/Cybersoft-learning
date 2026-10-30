package com.ndt.bookshop_authentication.controller;

import lombok.RequiredArgsConstructor;


import org.slf4j.Logger;
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

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
        @Validated @RequestBody AuthReq authReq
    ) {
        logger.info("Sign in attempt for email: {}", authReq);
        String token = authService.signIn(authReq);
        ApiResp resp = ApiResp.builder()
            .status(200)
            .message("Sign in successful")
            .data(token)
            .build();
        logger.info("Sign in successful for email: {}", resp);
        return ResponseEntity.ok(resp);
    }
}
