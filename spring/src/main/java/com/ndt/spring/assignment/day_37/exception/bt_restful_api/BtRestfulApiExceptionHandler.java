package com.ndt.spring.assignment.day_37.exception.bt_restful_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.exception.BaseExceptionHandler;

import com.ndt.spring.assignment.day_37.response.exception.Q8ApiError;
import com.ndt.spring.assignment.day_37.response.exception.Q9ApiError;


@RestControllerAdvice
public class BtRestfulApiExceptionHandler implements BaseExceptionHandler {
    /**
     * As of 5.3, {@link ExceptionHandler} methods in {@link org.springframework.web.bind.annotation.ControllerAdvice}
     * can be used to handle exceptions from any {@link org.springframework.stereotype.Controller} or any other handler.
     * Moreover, it can simultaneously handle 1 or multiple assigned exceptions
     */
    @ExceptionHandler(Q8Exception.class)
    public ResponseEntity<Q8ApiError> handleAssignmentDay37Q8RestfulApiError(Q8Exception ex) {
        final Q8ErrorMsg errorMsg = ex.getErrorMsg();
        final HttpStatus status = errorMsg.getHttpStatus();
        final Q8ApiError body = createErrorMsgDTO(errorMsg, Q8ApiError::new);
        return ResponseEntity.status(status).body(body);
    }


    @ExceptionHandler(Q9Exception.class)
    public ResponseEntity<Q9ApiError> handleAssignmentDay37Q9RestfulApiError(Q9Exception ex) {
        final Q9ErrorMsg errorMsg = ex.getErrorMsg();
        final HttpStatus status = errorMsg.getHttpStatus();
        final Q9ApiError body = createErrorMsgDTO(errorMsg, Q9ApiError::new);
        return ResponseEntity.status(status).body(body);
    }
}
