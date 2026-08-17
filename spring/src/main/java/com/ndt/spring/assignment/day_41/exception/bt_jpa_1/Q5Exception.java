package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import com.ndt.spring.exception.BaseException;


public class Q5Exception extends BaseException {
    public Q5Exception(Q5ErrorMsg errorMsg) {
        super(errorMsg, null);
    }


    public Q5Exception(Q5ErrorMsg errorMsg, String overrideMsg) {
        super(errorMsg, overrideMsg);
    }
}
