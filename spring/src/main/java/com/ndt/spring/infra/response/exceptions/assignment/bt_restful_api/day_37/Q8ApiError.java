package com.ndt.spring.infra.response.exceptions.assignment.bt_restful_api.day_37;


import com.ndt.spring.infra.response.exceptions.ApiErrorResponse;


public record Q8ApiError(Integer status, String msg) implements ApiErrorResponse {
}
