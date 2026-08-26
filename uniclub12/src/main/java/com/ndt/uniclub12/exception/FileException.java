package com.ndt.uniclub12.exception;


public final class AuthenException extends BaseException {
    public AuthenException(GenericErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public AuthenException(GenericErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
