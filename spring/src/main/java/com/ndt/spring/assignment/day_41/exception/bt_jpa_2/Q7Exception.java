package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import com.ndt.spring.exception.BaseException;


public final class Q7Exception extends BaseException {
    public Q7Exception(Q7ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q7Exception(Q7ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
