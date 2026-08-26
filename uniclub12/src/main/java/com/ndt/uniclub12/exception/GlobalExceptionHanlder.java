package com.ndt.uniclub12.exception;

import java.util.stream.Collectors;


import org.springframework.http.ResponseEntity;
import org.springframework.context.MessageSourceResolvable;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;


import org.springframework.web.method.annotation.HandlerMethodValidationException;


import com.ndt.uniclub12.payload.response.exception.ApiErrorResponse;


@ControllerAdvice
public class GlobalExceptionHanlder implements BaseExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
            .status(500)
            .body(new ApiErrorResponse("500", "Internal Error"));
    }


    @ExceptionHandler(SaveFileException.class)
    public ResponseEntity<ApiErrorResponse> handleSaveFileException(SaveFileException e) {
        return ResponseEntity.status(200)
            .body(new ApiErrorResponse("200", "Save file error"));
    }


    @ExceptionHandler(AuthenException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthenException(AuthenException e) {
        return buildResponse(e.getErrorMsg(), e.getOverrideMsg());
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        System.out.println(ex.getMessage());
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
            .collect(Collectors.joining("; "));

        return ResponseEntity
            .status(GenericErrorMsg.BAD_REQUEST.getHttpStatus())
            .body(createErrorMsgDTO(GenericErrorMsg.BAD_REQUEST, message, ApiErrorResponse::new));
    }


    @ExceptionHandler({HandlerMethodValidationException.class})
    public ResponseEntity<ApiErrorResponse> handleHandlerMethodValidationException(HandlerMethodValidationException ex) {
        String message = ex.getAllErrors().stream()
            .map(MessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.joining("; "));

        return ResponseEntity
            .status(GenericErrorMsg.BAD_REQUEST.getHttpStatus())
            .body(createErrorMsgDTO(GenericErrorMsg.BAD_REQUEST, message, ApiErrorResponse::new));
    }
}
