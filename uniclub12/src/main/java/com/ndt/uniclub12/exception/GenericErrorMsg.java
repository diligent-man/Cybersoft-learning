package com.ndt.uniclub12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum GenericErrorMsg implements ErrorMsg {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type"),
    CONFLICT(HttpStatus.CONFLICT, "Resource already exists"),

    READ_IMAGE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to read image"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something wrong happened");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
