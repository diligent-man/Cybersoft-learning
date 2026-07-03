package com.ndt.spring.assignment.day_41.controller.bt_jpa_1;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.UserEntity;
import com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2.UserService;


@RequiredArgsConstructor
@RestController("btJpa1Q2Controller")
@RequestMapping("/assignment/day_41/jpa1/q2")
public class Q2Controller {
    @Qualifier("btJpa1Q2UserService")
    private final UserService userService;


    @GetMapping("")
    public ResponseEntity<List<UserEntity>> get() {
        return ResponseEntity.ok(userService.getAll());
    }
}
