package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q9Service;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q9CustomerEntity;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ9Controller")
@RequestMapping("/assignment/day_37/restful-api/q9")
public class Q9Controller {
    private final Q9Service q9Service;


    @GetMapping("/customers")
    public ResponseEntity<List<Q9CustomerEntity>> getCustomers() {
        return ResponseEntity.ok(q9Service.getCustomers());
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity<Q9CustomerEntity> getCustomer(
        @PathVariable int id
    ) {
        return ResponseEntity.ok(q9Service.getCustomer(id));
    }

    // TODO: add api
    // TODO: update api
    // TODO: delete api
}
