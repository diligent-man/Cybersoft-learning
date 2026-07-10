package com.ndt.spring.payload.resp.exception;


public record GenericApiError(Integer code, String status) implements ApiErrorResponse {
}
