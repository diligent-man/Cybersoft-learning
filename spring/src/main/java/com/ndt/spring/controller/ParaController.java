package com.ndt.spring.controller;


import com.ndt.spring.request.DeleteUserRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


/*
    Có 2 loại tham số:
        a/ Tham số truyền trên trình duyệt
            + query param - @RequestParam
            + path variable - @PathVariable
        b/ Tham số truyền ngầm - also @RequestParam
 */
@RestController(value = "paraController")
@RequestMapping({"/param"})
public class ParaController {
    @GetMapping("")
    public ResponseEntity<String> getParam() {
        return ResponseEntity.ok("param");
    }


    @GetMapping("/")
    public ResponseEntity<String> getParam(
        @RequestParam int count,
        @RequestParam String content
    ) {
        return ResponseEntity.ok(String.format("%d: %s", count, content));
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getParam(
        @PathVariable String id
    ) {
        return ResponseEntity.ok(id);
    }


    @PostMapping
    public ResponseEntity<String> createUser(
        @RequestParam String username,
        @RequestParam String password
    ) {
        return ResponseEntity.ok(String.format("username: %s, password: %s", username, password));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
        @PathVariable String id,
        @RequestParam String username,
        @RequestParam String password
    ) {
        return ResponseEntity.ok(String.format("id: %s, username: %s, password: %s", id, username, password));
    }


    @DeleteMapping
    public ResponseEntity<String> deleteUser(
        DeleteUserRequest userRequest
    ){
        return ResponseEntity.ok(userRequest.toString());
    }
}
