package com.ndt.uniclub12.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import com.ndt.uniclub12.payload.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleRuntimeException(RuntimeException e) {
        BaseResponse baseResponse = BaseResponse.builder().code(500).message("Internal Error").build();
        return ResponseEntity.ok(baseResponse);
    }


    @ExceptionHandler(SaveFileException.class)
    public ResponseEntity<BaseResponse> handleSaveFileException(SaveFileException e) {
        BaseResponse baseResponse = BaseResponse.builder().code(200).message("Save file error").build();
        return ResponseEntity.ok(baseResponse);
    }
}
