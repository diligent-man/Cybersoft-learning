/* Ref: https://josealopez.dev/en/blog/spring-boot-global-exception-handling#global-exception-handler */
package com.ndt.spring.assignment.day_37.controller.bt_restful_api;

import java.util.Map;


import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartFile;


import com.ndt.spring.exceptions.GenericErrorMsg;
import com.ndt.spring.exceptions.GenericException;

import com.ndt.spring.assignment.day_37.service.bt_restful_api.Q8Service;

import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8ErrorMsg;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8Exception;

import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q8EmployeeEntity;


@RequiredArgsConstructor
@RestController("btRestfullAPIQ8Controller")
@RequestMapping("/assignment/day_37/restful-api/q8")
public class Q8Controller {
    private final Q8Service q8Service;


    @GetMapping("/employees/{id}")
    public ResponseEntity<Q8EmployeeEntity> getEmployee(@PathVariable Integer id) {
        return q8Service
            .getEmployee(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new Q8Exception(Q8ErrorMsg.EMPLOYEE_NOT_FOUND));
    }


    // Additional method for testing GenericError functionality
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable Integer id) {
        throw new Q8Exception(Q8ErrorMsg.EMPLOYEE_UNSUPPORTED_DELETION);
    }


    // Additional method for testing GenericError functionality
    @PostMapping("/employees/{id}/upload")
    public ResponseEntity<Map<String, Object>> uploadEmployeeAvatar(
        @PathVariable Integer id,
        @RequestParam("image") MultipartFile image
    ) {
        throw new GenericException(GenericErrorMsg.BAD_REQUEST);
    }
}
