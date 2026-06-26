package com.ndt.spring.infra.response.exceptions;


public record GenericApiError(Integer status, String msg) implements ApiErrorResponse{
}
