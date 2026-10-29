package com.ndt.bookshop_authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ndt.bookshop_authentication.payload.resp.ApiResp;


@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<?> handleDataNotFoundException(DataNotFound ex) {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(
                ApiResp.builder()
                    .status(HttpStatus.NO_CONTENT.value())
                    .message("Error: " + ex.getMessage())
                    .build()
            );
    }
}
