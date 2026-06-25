package com.ndt.spring.assignment.day_37.exceptions.bt_restful_api;

import java.util.Arrays;


import lombok.*;


import org.springframework.http.HttpStatus;


@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q8ErrorMsg {
    // Employee
    EMPLOYEE_NOT_FOUND(HttpStatus.NOT_FOUND, "Employee not found"),

    // GENERIC
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong happened"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    READ_IMAGE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to read image");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;


    public static HttpStatus getHttpStatus(Q8ErrorMsg errorMsg) {
        return Arrays.stream(Q8ErrorMsg.values())
            .filter(ele -> ele.equals(errorMsg))
            .findFirst()
            .map(ele -> ele.httpStatus)
            .orElse(null);

    }


    public static String getMessage(Q8ErrorMsg errorMessage) {
        return Arrays.stream(Q8ErrorMsg.values())
            .filter(ele -> ele.equals(errorMessage))
            .findFirst()
            .map(ele -> ele.errorMsg)
            .orElse(null);
    }


    public static Q8ErrorMsg getFromHttpStatus(HttpStatus code) {
        return Arrays.stream(Q8ErrorMsg.values())
            .filter(ele -> ele.httpStatus.equals(code))
            .findFirst()
            .orElse(INTERNAL_SERVER_ERROR);
    }
}
