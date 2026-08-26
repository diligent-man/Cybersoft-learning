package com.ndt.spring.assignment.day_37.response.exception;


import com.ndt.spring.payload.resp.exception.ApiErrResp;


public record Q9ApiError(String code, String status) implements ApiErrResp {
}
