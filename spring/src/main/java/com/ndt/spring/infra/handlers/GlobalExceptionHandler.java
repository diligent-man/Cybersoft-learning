package com.ndt.spring.infra.handlers;


import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8ErrorMsg;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8Exception;
import com.ndt.spring.infra.dtos.assignment.day_37.bt_restful_api.Q8ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Q8Exception.class)
    public ResponseEntity<Q8ApiError> handleAssignmentDay37RestfulApiError(Q8Exception ex) {
        final Q8ErrorMsg errorMessage = ex.getErrorMsg();
        final HttpStatus status = Q8ErrorMsg.getHttpStatus(errorMessage);
        final Q8ApiError body = createQ8ApiError(errorMessage);
        return ResponseEntity.status(status).body(body);
    }


    private Q8ApiError createQ8ApiError(Q8ErrorMsg errorMessage) {
        final String message = Q8ErrorMsg.getMessage(errorMessage);
        return new Q8ApiError(errorMessage, message);
    }


    private Q8ApiError createQ8ApiError(Q8ErrorMsg errorMessage, String message) {
        return new Q8ApiError(errorMessage, message);
    }
}
