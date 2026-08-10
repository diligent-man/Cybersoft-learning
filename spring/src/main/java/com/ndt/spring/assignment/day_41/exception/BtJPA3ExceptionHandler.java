package com.ndt.spring.assignment.day_41.exception;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.*;

import com.ndt.spring.exception.BaseException;
import com.ndt.spring.exception.BaseExceptionHandler;
import com.ndt.spring.payload.resp.exception.ApiErrorResponse;


@RestControllerAdvice
public class BtJPA3ExceptionHandler implements BaseExceptionHandler {
    @ExceptionHandler({
        Q1Exception.class,
    })
    public ResponseEntity<ApiErrorResponse> handleException(BaseException ex) {
        return buildResponse(ex.getErrorMsg(), ex.getOverrideMsg());
    }
}
