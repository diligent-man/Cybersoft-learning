package com.ndt.spring.day_40.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.day_40.service.LoginService;


@RequiredArgsConstructor
@RestController("loginController")
@RequestMapping("/day_40/demo-query-creation/login")
public class LoginController {
    private final LoginService loginService;


    @PostMapping
    public ResponseEntity<Boolean> doLogin(
        @RequestParam String email,
        @RequestParam String password
    ) {
        boolean isSuccess = loginService.authenticate(email, password);
        return ResponseEntity.ok(isSuccess);
    }
}
