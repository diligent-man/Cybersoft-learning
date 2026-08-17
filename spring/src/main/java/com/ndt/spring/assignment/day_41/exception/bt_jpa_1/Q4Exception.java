package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import com.ndt.spring.exception.BaseException;


public class Q4Exception extends BaseException {
    public Q4Exception(Q4ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q4Exception(Q4ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
