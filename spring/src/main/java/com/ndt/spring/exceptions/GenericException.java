package com.ndt.spring.exceptions;

import lombok.*;


@Getter
@RequiredArgsConstructor
public final class GenericException extends RuntimeException {
    private final GenericErrorMsg errorMsg;
}
