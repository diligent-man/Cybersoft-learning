package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import com.ndt.spring.exception.BaseException;


public final class Q5Exception extends BaseException {
    public Q5Exception(Q5ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q5Exception(Q5ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
