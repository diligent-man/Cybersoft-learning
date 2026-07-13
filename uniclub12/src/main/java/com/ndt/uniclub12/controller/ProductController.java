package com.ndt.uniclub12.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok("Get product");
    }


    @PostMapping
    public ResponseEntity<?> addProduct() {
        return ResponseEntity.ok("Add product");
    }
}
