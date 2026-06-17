package com.ndt.spring.assignment.day_37.controller.bt_restful_api;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q4ProductEntity;
import com.ndt.spring.assignment.day_37.request.bt_restful_api.Q4Request;
import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        return ResponseEntity.ok(q4Service.getProduct(id));
    }


    @PostMapping("/products")
    public ResponseEntity<Map<String, Object>> getProduct(
        @RequestBody Q4Request body
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
        @RequestBody Q4Request body
    ) {
        // TODO: how to update ?

        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        // Q4ProductEntity newProduct = body.getQ4ProductEntity();
        // Q4ProductEntity oldProduct = q4Service.getProduct(id);

        Map<String, Object> result = new HashMap<>();
        return ResponseEntity.status(statusCode).body(result);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> updateProduct(
        @PathVariable Integer id
    ) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        if (q4Service.removeProduct(id))
            statusCode = HttpStatus.OK;

        return ResponseEntity.status(statusCode).body(statusCode == HttpStatus.OK);
    }
}
