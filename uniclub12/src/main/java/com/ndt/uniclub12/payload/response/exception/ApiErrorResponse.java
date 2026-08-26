package com.ndt.uniclub12.payload.response.exception;


public record ApiErrorResponse(String code, String status) implements ApiErrResp { }
