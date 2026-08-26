package com.ndt.uniclub12.exception;


public final class AuthenException extends BaseException {
    public AuthenException(AuthenErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public AuthenException(AuthenErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
