package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import lombok.*;


@Getter
@RequiredArgsConstructor
public class Q1Exception extends RuntimeException {
    private final Q1ErrorMsg errorMsg;
}
