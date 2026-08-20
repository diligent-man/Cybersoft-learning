package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q5ErrorMsg implements ErrorMsg {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "student not found"),
    STUDENT_EXISTED(HttpStatus.NOT_FOUND, "student has been existed"),

    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "course not found"),
    COURSE_EXISTED(HttpStatus.NOT_FOUND, "course has been registered"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
