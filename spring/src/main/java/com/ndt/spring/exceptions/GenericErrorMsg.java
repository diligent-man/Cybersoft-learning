package com.ndt.spring.exceptions;

import lombok.*;


import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum GenericErrorMsg implements ErrorMsg {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    READ_IMAGE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to read image"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong happened");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
