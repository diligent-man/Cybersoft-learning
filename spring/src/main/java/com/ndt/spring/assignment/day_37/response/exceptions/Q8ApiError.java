package com.ndt.spring.assignment.day_37.response.exceptions;


import com.ndt.spring.response.exceptions.ApiErrorResponse;


public record Q8ApiError(Integer status, String msg) implements ApiErrorResponse {
}
