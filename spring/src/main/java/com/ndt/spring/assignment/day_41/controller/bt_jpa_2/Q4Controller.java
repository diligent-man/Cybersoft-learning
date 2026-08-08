package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.ProductEntity;

import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4.AddProductReq;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q4.ProductsResp;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4.AddCategoryReq;

import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q4.ProductService;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q4.CategoryService;


@RequiredArgsConstructor
@RestController("btJPA2Q4Controller")
@RequestMapping("/assignment/day_41/jpa2/q4/api/categories")
public class Q4Controller {
    @Qualifier("btJPA2Q4CategoryService")
    private final CategoryService categoryService;

    @Qualifier("btJPA2Q4ProductService")
    private final ProductService productService;


    @GetMapping("/{id}/products")
    public ResponseEntity<ApiResponse> getProductsByCategory(
        @PathVariable
        @Positive(message = "id must be a positive number")
        Integer id
    ) {
        ProductsResp products = ProductsResp.builder().products(categoryService.getProductsByCategory(id)).build();

        return ResponseEntity.ok(ApiResponse.builder()
            .code("200")
            .status("success")
            .data(products)
            .build());
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(
        @Valid @RequestBody AddCategoryReq req
    ) {
        CategoryEntity category = categoryService.addCategory(req);
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(category)
                .build()
        );
    }


    @PostMapping("{id}/products")
    public ResponseEntity<ApiResponse> addProduct(
        @PathVariable @Positive Integer id,
        @Valid @RequestBody AddProductReq req
    ) {
        ProductEntity product = productService.addProduct(id, req);
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(product)
                .build()
        );
    }
}
