package com.ndt.spring.assignment.day_37.exceptions.bt_restful_api;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exceptions.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q8ErrorMsg implements ErrorMsg {
    // Employee
    EMPLOYEE_NOT_FOUND(HttpStatus.NOT_FOUND, "Employee not found"),
    EMPLOYEE_UNSUPPORTED_DELETION(HttpStatus.NOT_FOUND, "Employee not supports deletion");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
