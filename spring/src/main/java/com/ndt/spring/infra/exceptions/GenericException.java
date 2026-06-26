package com.ndt.spring.infra.exceptions;

import lombok.*;


@Getter
@RequiredArgsConstructor
public final class GenericException extends RuntimeException {
    private final GenericErrorMsg errorMsg;
}
