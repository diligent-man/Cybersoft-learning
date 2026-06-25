package com.ndt.spring.assignment.day_37.exceptions.bt_restful_api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class Q8Exception extends RuntimeException {
    private final Q8ErrorMsg errorMsg;
}
