package com.ndt.uniclub12.exception;


public final class FileException extends BaseException {
    public FileException(FileErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public FileException(FileErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
