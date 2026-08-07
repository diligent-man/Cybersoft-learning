package com.ndt.spring.exception;

import java.util.stream.Collectors;
import java.sql.SQLIntegrityConstraintViolationException;


import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.payload.resp.exception.ApiErrorResponse;


/**
 * Use {@link RestControllerAdvice} to handle all application exceptions (from non-REST & REST controller) centrally and globally. A shortcut annotation that
 * combines {@link org.springframework.web.bind.annotation.ControllerAdvice} with {@link org.springframework.web.bind.annotation.ResponseBody},
 * in effect simply an {@link org.springframework.web.bind.annotation.ControllerAdvice} whose exception handler methods render to the response body.
 * In addition, we can limit the effect of global exception handle via <i>basePackages</i> and <i>assignableTypes</i> parameters.
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements BaseExceptionHandler {
    // Handle user-defined generic exception
    @ExceptionHandler({GenericException.class})
    public ResponseEntity<ApiErrorResponse> handleGenericException(GenericException ex) {
        return buildResponse(ex.getErrorMsg(), ex.getOverrideMsg());
    }


    // Handle file uploading
    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ApiErrorResponse> handleMultipartException() {
        return buildResponse(GenericErrorMsg.BAD_REQUEST);
    }


    // Handle inbound media types
    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<ApiErrorResponse> handleHttpMediaTypeException(HttpMediaTypeException ex) {
        return buildResponse(
            ErrorMsg.fromErrorResponse(GenericErrorMsg.class, ex),
            ex.getMessage()
        );
    }


    // Handle validations from jakarta.validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        System.out.println(ex.getMessage());
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
            .collect(Collectors.joining("; "));

        return ResponseEntity
            .status(GenericErrorMsg.BAD_REQUEST.getHttpStatus())
            .body(createErrorMsgDTO(GenericErrorMsg.BAD_REQUEST, message, ApiErrorResponse::new));
    }


    // Handle sql integrity constrain violation (e.g. duplicate, not null, etc.)
    @ExceptionHandler({
        SQLIntegrityConstraintViolationException.class
    })
    public ResponseEntity<ApiErrorResponse> handleDataIntegrityViolation(SQLIntegrityConstraintViolationException ex) {
        return ResponseEntity
            .status(GenericErrorMsg.CONFLICT.getHttpStatus())
            .body(createErrorMsgDTO(GenericErrorMsg.CONFLICT, ex.getMessage(), ApiErrorResponse::new));
    }
}
