package com.ndt.spring.assignment.day_41.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.exception.BaseExceptionHandler;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1Exception;

import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.exception.Q1ApiError;


@RestControllerAdvice
public class BtJPA1ExceptionHandler implements BaseExceptionHandler {
    @ExceptionHandler(Q1Exception.class)
    public ResponseEntity<Q1ApiError> handleAssignmentDay41Q1RestfulApiError(Q1Exception ex) {
        final Q1ErrorMsg errorMsg = ex.getErrorMsg();
        final HttpStatus status = errorMsg.getHttpStatus();
        final Q1ApiError body = createErrorMsgDTO(errorMsg, Q1ApiError::new);
        return ResponseEntity.status(status).body(body);
    }
}
