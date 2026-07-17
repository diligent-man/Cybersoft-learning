package com.ndt.uniclub12.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import com.ndt.uniclub12.payload.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleException(RuntimeException ex) {
        BaseResponse baseResponse = BaseResponse.builder().code(200).message(ex.getMessage()).build();
        return ResponseEntity.ok(baseResponse);
    }
}
