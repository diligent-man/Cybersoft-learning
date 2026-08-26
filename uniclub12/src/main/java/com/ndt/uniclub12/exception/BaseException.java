package com.ndt.uniclub12.exception;

import lombok.Getter;


@Getter
public abstract class BaseException extends RuntimeException {
    protected final ErrorMsg errorMsg;

    protected final String overrideMsg;


    public <T extends ErrorMsg> BaseException(T errorMsg) {
        this(errorMsg, null);
    }


    public <T extends ErrorMsg> BaseException(T errorMsg, String overrideMsg) {
        this.errorMsg = errorMsg;
        this.overrideMsg = overrideMsg;
    }
}
