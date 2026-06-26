package com.ndt.spring.infra.exceptions;

import java.util.Arrays;


import org.springframework.http.HttpStatus;


public interface ErrorMsg {
    HttpStatus getHttpStatus();


    String getErrorMsg();


    static <T extends Enum<T> & ErrorMsg> T getFromHttpStatus(Class<T> enumClass, HttpStatus code) {
        return Arrays.stream(enumClass.getEnumConstants())
            .filter(e -> e.getHttpStatus().equals(code))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No match for: " + code));
    }
}
