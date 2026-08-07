package com.ndt.spring.assignment.day_37.response.exception;


import com.ndt.spring.payload.resp.exception.ApiErrResp;


public record Q8ApiError(Integer code, String status) implements ApiErrResp {
}
