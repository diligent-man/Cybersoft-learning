package com.ndt.uniclub12.controller;


import com.ndt.uniclub12.payload.request.InsertProductRequest;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.ndt.uniclub12.service.ProductService;


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
        InsertProductRequest insertProductRequest
    ) {
        // int code = 200;
        // String message = "";
        // try {
        //     productService.insertProduct(file);
        //
        //     message = "Uploaded the file successfully: " + file.getOriginalFilename();
        //     return ResponseEntity.ok(
        //         UploadFileResponse.builder()
        //             .code(code)
        //             .message(message)
        //             .build()
        //     );
        // } catch (Exception e) {
        //     code = 417;
        //     message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
        //     return ResponseEntity
        //         .status(HttpStatus.EXPECTATION_FAILED)
        //         .body(UploadFileResponse.builder().code(code).message(message));
        // }
        productService.insertProduct(insertProductRequest);
        return ResponseEntity.ok("Add product");
    }
}
