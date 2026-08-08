package com.ndt.spring.assignment.day_41.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.*;

import com.ndt.spring.exception.BaseException;
import com.ndt.spring.exception.BaseExceptionHandler;
import com.ndt.spring.payload.resp.exception.ApiErrorResponse;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q2Exception;


@RestControllerAdvice
public class BtJPA2ExceptionHandler implements BaseExceptionHandler {
    @ExceptionHandler({
        Q2Exception.class,
        Q4Exception.class,
        Q5Exception.class,
        Q7Exception.class
    })
    public ResponseEntity<ApiErrorResponse> handleException(BaseException ex) {
        return buildResponse(ex.getErrorMsg(), ex.getOverrideMsg());
    }
}
