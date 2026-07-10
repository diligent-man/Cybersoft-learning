package com.ndt.spring.exception;

import lombok.*;


@Getter
@RequiredArgsConstructor
public final class GenericException extends RuntimeException {
    private final GenericErrorMsg errorMsg;
}
