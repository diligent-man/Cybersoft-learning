package com.ndt.spring.exception;

import lombok.Getter;


@Getter
public final class GenericException extends RuntimeException {
    private final GenericErrorMsg errorMsg;

    private final String overrideMsg;


    public GenericException(GenericErrorMsg errorMsg) {
        this(errorMsg, null);
    }


    public GenericException(GenericErrorMsg errorMsg, String overrideMsg) {
        this.errorMsg = errorMsg;
        this.overrideMsg = overrideMsg;
    }
}
