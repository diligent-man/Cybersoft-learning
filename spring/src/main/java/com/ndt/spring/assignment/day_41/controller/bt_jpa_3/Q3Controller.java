package com.ndt.spring.assignment.day_41.controller.bt_jpa_3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q3.*;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q3.*;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_3.q3.*;

import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.service.bt_jpa_3.q3.ProductService;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_3.q3.ProductsResp;


@RequiredArgsConstructor
@RestController("btJPA3Q3Controller")
@RequestMapping("/assignment/day_41/jpa3/q3/api/products")
public class Q3Controller {
    @Qualifier("btJPA3Q3ProductService")
    private final ProductService productService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getProducts() {
        ProductsResp products = ProductsResp.builder().products(productService.getAll()).build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(products)
                .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProduct(
        @PathVariable @Positive Integer id
    ) {
        ProductResp product = ProductResp.builder().product(productService.getById(id)).build();
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(product)
                .build()
        );
    }


    @PostMapping("")
    public ResponseEntity<ApiResponse> addProduct(
        @Valid @RequestBody AddProductReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(productService.save(req))
                .build()
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(
        @PathVariable @Positive Integer id,
        @Valid @RequestBody UpdateProductReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(productService.update(id, req))
                .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable @Positive Integer id) {
        ProductDTO product = productService.delete(id);

        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("Student with name " + product.getName() + " has been deleted")
                .data(product)
                .build()
        );
    }


    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchProduct(
        @Valid @ModelAttribute SearchProductReq req,
        @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(productService.searchProducts(req.getCategoryId(), pageable))
                .build()
        );
    }
}
