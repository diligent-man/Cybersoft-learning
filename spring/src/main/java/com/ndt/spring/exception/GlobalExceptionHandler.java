package com.ndt.spring.exception;

import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.payload.resp.exception.GenericApiError;


/**
 * Use {@link RestControllerAdvice} to handle all application exceptions (from non-REST & REST controller) centrally and globally. A shortcut annotation that
 * combines {@link org.springframework.web.bind.annotation.ControllerAdvice} with {@link org.springframework.web.bind.annotation.ResponseBody},
 * in effect simply an {@link org.springframework.web.bind.annotation.ControllerAdvice} whose exception handler methods render to the response body.
 * In addition, we can limit the effect of global exception handle via <i>basePackages</i> and <i>assignableTypes</i> parameters.
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements BaseExceptionHandler {
    @ExceptionHandler({GenericException.class})
    public ResponseEntity<GenericApiError> handleGenericException(GenericException ex) {
        return buildGenericResponse(ex.getErrorMsg());
    }


    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<GenericApiError> handleMultipartException() {
        return buildGenericResponse(GenericErrorMsg.BAD_REQUEST);
    }


    private ResponseEntity<GenericApiError> buildGenericResponse(GenericErrorMsg errorMsg) {
        return ResponseEntity
            .status(errorMsg.getHttpStatus())
            .body(createErrorMsgDTO(errorMsg, GenericApiError::new));
    }
}
