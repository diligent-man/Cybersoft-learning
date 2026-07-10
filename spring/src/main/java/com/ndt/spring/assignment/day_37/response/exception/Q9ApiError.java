package com.ndt.spring.assignment.day_37.response.exception;


import com.ndt.spring.payload.resp.exception.ApiErrorResponse;


public record Q9ApiError(Integer code, String status) implements ApiErrorResponse {
}
