package com.ndt.bookshop_authentication.exception;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class DataNotFound extends RuntimeException {
    private String message;

    public DataNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
