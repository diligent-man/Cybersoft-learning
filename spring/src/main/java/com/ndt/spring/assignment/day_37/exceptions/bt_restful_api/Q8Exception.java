package com.ndt.spring.assignment.day_37.exceptions.bt_restful_api;

import com.ndt.spring.exceptions.GlobalExceptionHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * An exception class to throw with input corresponding message (defined in {@link Q8ErrorMsg}). Then it is handled in
 * {@link GlobalExceptionHandler#handleAssignmentDay37RestfulApiError} via
 * {@link org.springframework.web.bind.annotation.ExceptionHandler} annotation (using Aspect-oriented programming (AOP)).
 */
@Getter
@RequiredArgsConstructor
public class Q8Exception extends RuntimeException {
    private final Q8ErrorMsg errorMsg;
}
