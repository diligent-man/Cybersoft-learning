package com.ndt.uniclub12.controller;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.uniclub12.utils.JwtUtils;


@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @GetMapping("/get-token")
    public ResponseEntity<String> generateJwtToken() {
        return ResponseEntity.ok(JwtUtils.generateJWTKey());
    }
}
