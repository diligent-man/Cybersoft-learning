package com.ndt.spring.assignment.day_37.controller.bt_restful_api;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q5StudentEntity;
import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q8EmployeeEntity;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8ErrorMsg;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8Exception;
import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q8Service;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ8Controller")
@RequestMapping("/assignment/day_37/restful-api/q8")
public class Q8Controller {
    private final Q8Service q8Service;


    @GetMapping("/employees/{id}")
    public ResponseEntity<Q8EmployeeEntity> getStudent(@PathVariable Integer id) {
        return q8Service
            .getEmployee(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new Q8Exception(Q8ErrorMsg.EMPLOYEE_NOT_FOUND));
    }
}
