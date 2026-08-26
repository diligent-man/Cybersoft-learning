package com.ndt.uniclub12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum FileErrorMsg implements ErrorMsg {
    LOGIN_SUCCESS(HttpStatus.OK, "Login success"),
    LOGIN_FAIL(HttpStatus.BAD_REQUEST, "Login fail");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;

}
