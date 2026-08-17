package com.ndt.spring.assignment.day_41.exception.bt_jpa_3;

import com.ndt.spring.exception.BaseException;


public final class Q3Exception extends BaseException {
    public Q3Exception(Q3ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q3Exception(Q3ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
