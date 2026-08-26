package com.ndt.spring.payload.resp.exception;


public record ApiErrorResponse(String code, String status) implements ApiErrResp {
}
