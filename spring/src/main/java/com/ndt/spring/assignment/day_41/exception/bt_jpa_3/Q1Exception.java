package com.ndt.spring.assignment.day_41.exception.bt_jpa_3;

import com.ndt.spring.exception.BaseException;


public final class Q1Exception extends BaseException {
    public Q1Exception(Q1ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q1Exception(Q1ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
