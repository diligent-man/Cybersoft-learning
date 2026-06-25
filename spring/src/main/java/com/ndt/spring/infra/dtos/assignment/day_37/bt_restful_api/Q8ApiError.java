package com.ndt.spring.infra.dtos.assignment.day_37.bt_restful_api;

import com.ndt.spring.assignment.day_37.exceptions.bt_restful_api.Q8ErrorMsg;


public record Q8ApiError(Q8ErrorMsg errorCode, String msg) {
}
