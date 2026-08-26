package com.ndt.uniclub12.controller;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.ndt.uniclub12.service.ProductService;

import com.ndt.uniclub12.payload.response.ApiResponse;
import com.ndt.uniclub12.payload.request.InsertProductRequest;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public ResponseEntity<ApiResponse> getProduct() {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .message("success")
                .data(productService.getProducts())
                .build()
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse> insertProduct(
        @Valid @ModelAttribute InsertProductRequest insertProductRequest
    ) {
        return ResponseEntity.ok(
            ApiResponse
                .builder()
                .code("200")
                .message("success")
                .data(productService.insertProduct(insertProductRequest))
                .build()
        );
    }
}
