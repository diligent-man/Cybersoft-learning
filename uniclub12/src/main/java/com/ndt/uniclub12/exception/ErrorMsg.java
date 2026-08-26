package com.ndt.uniclub12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;

import java.util.Arrays;


public interface ErrorMsg {
    HttpStatus getHttpStatus();


    String getErrorMsg();


    static <T extends Enum<T> & ErrorMsg> T fromErrorResponse(Class<T> enumClass, ErrorResponse errorResponse) {
        HttpStatusCode statusCode = errorResponse.getStatusCode();

        return Arrays.stream(enumClass.getEnumConstants())
            .filter(e -> e.getHttpStatus().value() == statusCode.value())
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No match for: " + statusCode));
    }
}
