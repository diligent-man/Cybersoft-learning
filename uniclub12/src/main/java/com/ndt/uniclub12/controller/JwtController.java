package com.ndt.uniclub12.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.uniclub12.utils.JwtUtils;


@RestController
@RequestMapping("/api/jwt")
public class JwtController {
    @GetMapping("/get-token")
    public ResponseEntity<Map<String, String>> generateJwtToken() {
        return ResponseEntity.ok(
            Map.of("jwt_token", JwtUtils.generateJWTKey())
        );
    }
}
