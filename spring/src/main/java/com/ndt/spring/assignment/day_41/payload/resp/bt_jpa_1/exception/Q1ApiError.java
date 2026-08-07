package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.exception;

import com.ndt.spring.payload.resp.exception.ApiErrResp;


public record Q1ApiError(Integer code, String status) implements ApiErrResp {
}
