package com.ndt.spring.exception;

import java.util.function.BiFunction;


import org.springframework.http.ResponseEntity;


import com.ndt.spring.payload.resp.exception.ApiErrResp;
import com.ndt.spring.payload.resp.exception.ApiErrorResponse;


public interface BaseExceptionHandler {
    default <T extends ApiErrResp> T createErrorMsgDTO(
        ErrorMsg errorMsg,
        BiFunction<Integer, String, T> factory
    ) {
        return factory.apply(
            errorMsg.getHttpStatus().value(),
            errorMsg.getErrorMsg()
        );
    }


    default <T extends ApiErrResp> T createErrorMsgDTO(
        ErrorMsg errorMsg,
        String overrideMsg,
        BiFunction<Integer, String, T> factory
    ) {
        return factory.apply(
            errorMsg.getHttpStatus().value(),
            overrideMsg != null ? overrideMsg : errorMsg.getErrorMsg()
        );
    }


    default <T extends ErrorMsg> ResponseEntity<ApiErrorResponse> buildResponse(T errorMsg) {
        return ResponseEntity
            .status(errorMsg.getHttpStatus())
            .body(createErrorMsgDTO(errorMsg, null, ApiErrorResponse::new));
    }


    default <T extends ErrorMsg> ResponseEntity<ApiErrorResponse> buildResponse(T errorMsg, String overrideMsg) {
        return ResponseEntity
            .status(errorMsg.getHttpStatus())
            .body(createErrorMsgDTO(errorMsg, overrideMsg, ApiErrorResponse::new));
    }
}
