package com.ndt.uniclub12.controller;

import com.ndt.uniclub12.enumeric.AuthenError;
import com.ndt.uniclub12.payload.response.BaseResponse;
import com.ndt.uniclub12.payload.response.SignInResponse;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.uniclub12.service.AuthenService;
import com.ndt.uniclub12.payload.request.SignInRequest;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenController {
    private final AuthenService authenService;


    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
        @RequestBody SignInRequest request
    ) {
        boolean isSuccess = authenService.doLogin(request);
        BaseResponse baseResponse = new SignInResponse(
            AuthenError.A00.toString(), "", Boolean.valueOf(isSuccess)
        );
        return ResponseEntity.ok(isSuccess);
    }
}
