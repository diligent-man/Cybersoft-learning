package com.ndt.spring.assignment.day_41.controller.bt_jpa_2;

import jakarta.validation.Valid;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.payload.resp.ApiResponse;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;
import com.ndt.spring.assignment.day_41.service.bt_jpa_2.q2.ProductService;

import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q2.ProductResp;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2.AddProductReq;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q2.ProductsResp;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2.UpdateProductReq;


@RequiredArgsConstructor
@RestController("btJPA2Q2Controller")
@RequestMapping("/assignment/day_41/jpa2/q2/api/products")
public class Q2Controller {
    @Qualifier("btJPA2Q2ProductService")
    private final ProductService productService;


    @GetMapping("")
    public ResponseEntity<ApiResponse> getProducts() {
        ProductsResp products = ProductsResp.builder().products(productService.getAll()).build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(products)
            .build();
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable Integer id) {
        ProductResp product = ProductResp.builder().product(productService.getById(id)).build();

        ApiResponse apiResponse = ApiResponse.builder()
            .code("200")
            .status("success")
            .data(product)
            .build();
        return ResponseEntity.ok(apiResponse);
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
        @PathVariable Integer id,
        @Valid @RequestBody UpdateProductReq req
    ) {
        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("success")
                .data(productService.updateProduct(id, req))
                .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id) {
        ProductEntity product = productService.delete(id);

        return ResponseEntity.ok(
            ApiResponse.builder()
                .code("200")
                .status("Product with name " + product.getName() + " 1has been deleted")
                .data(null)
                .build()
        );
    }
}
