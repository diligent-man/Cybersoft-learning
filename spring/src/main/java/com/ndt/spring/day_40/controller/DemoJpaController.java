package com.ndt.spring.day_40.controller;

import java.util.List;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.spring.day_40.mapper.RoleMapper;
import com.ndt.spring.day_40.mapper.UserMapper;

import com.ndt.spring.day_40.service.RoleService;
import com.ndt.spring.day_40.service.UserService;

import com.ndt.spring.day_40.dto.RoleDTO;
import com.ndt.spring.day_40.dto.UserDTO;



@RequiredArgsConstructor
@RestController("demoJpaController")
@RequestMapping("/day_40/demo-jpa")
public class DemoJpaController {
    private final RoleService roleService;

    private final UserService userService;

    private final UserMapper userMapper = new UserMapper();

    private final RoleMapper roleMapper = new RoleMapper();


    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getRoles() {
        return ResponseEntity.ok(
            roleService
                .getAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList()
        );
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(
            userService
                .getAll()
                .stream()
                .map(userMapper::toDTO)
                .toList()
        );
    }
}
