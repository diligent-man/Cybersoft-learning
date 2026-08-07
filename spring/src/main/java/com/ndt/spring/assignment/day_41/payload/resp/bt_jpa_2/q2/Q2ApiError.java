package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q2;


import com.ndt.spring.payload.resp.exception.ApiErrResp;


public record Q2ApiError(Integer code, String status) implements ApiErrResp {
}
