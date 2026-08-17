package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import com.ndt.spring.exception.BaseException;


public class Q2Exception extends BaseException {
    public Q2Exception(Q2ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q2Exception(Q2ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
