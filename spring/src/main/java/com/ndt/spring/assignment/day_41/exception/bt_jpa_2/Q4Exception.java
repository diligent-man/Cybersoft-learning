package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import com.ndt.spring.exception.BaseException;


public final class Q4Exception extends BaseException {
    public Q4Exception(Q4ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q4Exception(Q4ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
