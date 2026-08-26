package com.ndt.spring.payload.resp.exception;


public record ApiErrorResponse(Integer code, String status) implements ApiErrResp {
}
