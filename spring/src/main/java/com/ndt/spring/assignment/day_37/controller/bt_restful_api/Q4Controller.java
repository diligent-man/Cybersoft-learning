package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import java.util.*;


import lombok.RequiredArgsConstructor;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q4Service;

import com.ndt.spring.assignment.day_37.request.bt_restful_api.Q4PutRequest;
import com.ndt.spring.assignment.day_37.request.bt_restful_api.Q4PostRequest;

import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q4ProductEntity;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ4Controller")
@RequestMapping("/assignment/day_37/restful-api/q4")
public class Q4Controller {
    private final Q4Service q4Service;


    @GetMapping("/products")
    public ResponseEntity<List<Q4ProductEntity>> getAll() {
        return ResponseEntity.ok(q4Service.getProducts());
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Q4ProductEntity> getProduct(
        @PathVariable Integer id
    ) {
        return q4Service.getProduct(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping("/products")
    public ResponseEntity<Map<String, Object>> addProduct(
        @RequestBody Q4PostRequest body
    ) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        Q4ProductEntity newProduct = body.getQ4ProductEntity();

        Map<String, Object> result = new HashMap<>();

        if (q4Service.addProduct(newProduct)) {
            result.put("added_obj", newProduct);
            statusCode = HttpStatus.OK;
        }

        result.put("num_obj", q4Service.getProducts().size());
        return ResponseEntity.status(statusCode).body(result);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(
        @PathVariable Integer id,
        @RequestBody Q4PutRequest body
    ) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        if (q4Service.updateProduct(id, body))
            statusCode = HttpStatus.OK;

        Map<String, Object> result = new HashMap<>();
        result.put("updated_obj", q4Service.getProduct(id));

        return ResponseEntity.status(statusCode).body(result);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(
        @PathVariable Integer id
    ) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        if (q4Service.removeProduct(id))
            statusCode = HttpStatus.OK;

        return ResponseEntity.status(statusCode).body(
            String.format("is_removed: %b", statusCode == HttpStatus.OK)
        );
    }
}
