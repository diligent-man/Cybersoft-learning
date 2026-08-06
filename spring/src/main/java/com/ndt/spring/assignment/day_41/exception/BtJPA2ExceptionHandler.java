package com.ndt.spring.assignment.day_41.exception;

import com.ndt.spring.exception.BaseExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BtJPA2ExceptionHandler implements BaseExceptionHandler {
    // @ExceptionHandler(Q1Exception.class)
    // public ResponseEntity<Q1ApiError> handleAssignmentDay41Q1RestfulApiError(Q1Exception ex) {
    //     final Q1ErrorMsg errorMsg = ex.getErrorMsg();
    //     final HttpStatus status = errorMsg.getHttpStatus();
    //     final Q1ApiError body = createErrorMsgDTO(errorMsg, Q1ApiError::new);
    //     return ResponseEntity.status(status).body(body);
    // }
}
