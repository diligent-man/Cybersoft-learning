package com.ndt.spring.infra.handlers;

import java.util.function.BiFunction;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.ndt.spring.infra.exceptions.ErrorMsg;
import com.ndt.spring.infra.exceptions.GenericErrorMsg;
import com.ndt.spring.infra.exceptions.GenericException;

import com.ndt.spring.infra.response.exceptions.GenericApiError;
import com.ndt.spring.infra.response.exceptions.ApiErrorResponse;

import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8ErrorMsg;
import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8Exception;

import com.ndt.spring.infra.response.exceptions.assignment.bt_restful_api.day_37.Q8ApiError;
import org.springframework.web.multipart.MultipartException;


/**
 * Use {@link RestControllerAdvice} to handle all application exceptions (from non-REST & REST controller) centrally and globally. A shortcut annotation that
 * combines {@link org.springframework.web.bind.annotation.ControllerAdvice} with {@link org.springframework.web.bind.annotation.ResponseBody},
 * in effect simply an {@link org.springframework.web.bind.annotation.ControllerAdvice} whose exception handler methods render to the response body.
 * In addition, we can limit the effect of global exception handle via <i>basePackages</i> and <i>assignableTypes</i> parameters.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * As of 5.3, {@link ExceptionHandler} methods in {@link org.springframework.web.bind.annotation.ControllerAdvice}
     * can be used to handle exceptions from any {@link org.springframework.stereotype.Controller} or any other handler.
     * Moreover, it can simultaneously handle 1 or multiple assigned exceptions
     */
    @ExceptionHandler(Q8Exception.class)
    public ResponseEntity<Q8ApiError> handleAssignmentDay37RestfulApiError(Q8Exception ex) {
        final Q8ErrorMsg errorMsg = ex.getErrorMsg();
        final HttpStatus status = errorMsg.getHttpStatus();
        final Q8ApiError body = createErrorMsgDTO(errorMsg, Q8ApiError::new);
        return ResponseEntity.status(status).body(body);
    }


    @ExceptionHandler({GenericException.class})
    public ResponseEntity<GenericApiError> handleGenericException(GenericException ex) {
        return buildGenericResponse(ex.getErrorMsg());
    }


    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<GenericApiError> handleMultipartException(MultipartException ex) {
        return buildGenericResponse(GenericErrorMsg.BAD_REQUEST);
    }


    private ResponseEntity<GenericApiError> buildGenericResponse(GenericErrorMsg errorMsg) {
        return ResponseEntity
            .status(errorMsg.getHttpStatus())
            .body(createErrorMsgDTO(errorMsg, GenericApiError::new));
    }


    private <T extends ApiErrorResponse> T createErrorMsgDTO(
        ErrorMsg errorMsg,
        BiFunction<Integer, String, T> factory
    ) {
        return factory.apply(
            errorMsg.getHttpStatus().value(),
            errorMsg.getErrorMsg()
        );
    }
}
