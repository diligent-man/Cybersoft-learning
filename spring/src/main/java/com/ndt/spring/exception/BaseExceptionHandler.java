package com.ndt.spring.exception;

import java.util.function.BiFunction;


import com.ndt.spring.payload.resp.exception.ApiErrorResponse;


public interface BaseExceptionHandler {
    default <T extends ApiErrorResponse> T createErrorMsgDTO(
        ErrorMsg errorMsg,
        BiFunction<Integer, String, T> factory
    ) {
        return factory.apply(
            errorMsg.getHttpStatus().value(),
            errorMsg.getErrorMsg()
        );
    }
}
