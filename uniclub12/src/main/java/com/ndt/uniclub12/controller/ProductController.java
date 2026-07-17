package com.ndt.uniclub12.controller;


import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.ndt.uniclub12.service.ProductService;
import com.ndt.uniclub12.payload.response.UploadFileResponse;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok("Get product");
    }


    @PostMapping
    public ResponseEntity<?> addProduct(
        @RequestParam("file") MultipartFile file
    ) {
        int code = 200;
        String message = "";
        try {
            productService.insertProduct(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.ok(
                UploadFileResponse.builder()
                    .code(code)
                    .message(message)
                    .build()
            );
        } catch (Exception e) {
            code = 417;
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(UploadFileResponse.builder().code(code).message(message));
        }
    }
}
