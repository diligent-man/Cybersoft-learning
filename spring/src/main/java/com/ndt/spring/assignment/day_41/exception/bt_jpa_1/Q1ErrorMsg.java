package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q1ErrorMsg implements ErrorMsg {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Student not found");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
