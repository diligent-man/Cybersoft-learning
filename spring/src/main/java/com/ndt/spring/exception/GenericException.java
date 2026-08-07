package com.ndt.spring.exception;


public final class GenericException extends BaseException {
    public GenericException(GenericErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public GenericException(GenericErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
