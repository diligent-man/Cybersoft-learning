package com.ndt.uniclub12.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ndt.uniclub12.payload.response.exception.ApiErrorResponse;


@ControllerAdvice
public class GlobalExceptionHanlder implements BaseExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
            .status(500)
            .body(new ApiErrorResponse("500", "Internal Error"));
    }


    @ExceptionHandler(SaveFileException.class)
    public ResponseEntity<ApiErrorResponse> handleSaveFileException(SaveFileException e) {
        return ResponseEntity.status(200)
            .body(new ApiErrorResponse("200", "Save file error"));
    }


    @ExceptionHandler(AuthenException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthenException(AuthenException e) {
        return buildResponse(e.getErrorMsg(), e.getOverrideMsg());
    }
}
