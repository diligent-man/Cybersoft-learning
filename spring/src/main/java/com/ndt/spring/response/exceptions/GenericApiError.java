package com.ndt.spring.response.exceptions;


public record GenericApiError(Integer status, String msg) implements ApiErrorResponse{
}
