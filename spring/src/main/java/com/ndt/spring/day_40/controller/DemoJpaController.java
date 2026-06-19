package com.ndt.spring.day_40.controller;

import java.util.List;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.spring.day_40.entity.RoleEntity;
import com.ndt.spring.day_40.service.RoleService;


@RequiredArgsConstructor
@RestController("demoJpaController")
@RequestMapping("/day_40/demo-jpa")
public class DemoJpaController {
    private final RoleService roleService;


    @GetMapping("/roles")
    public ResponseEntity<List<RoleEntity>> getRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }
}
