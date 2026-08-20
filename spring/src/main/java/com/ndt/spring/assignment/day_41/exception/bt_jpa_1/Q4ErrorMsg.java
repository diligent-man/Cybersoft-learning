package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import org.springframework.http.HttpStatus;


import lombok.*;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q4ErrorMsg implements ErrorMsg {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "student not found"),
    STUDENT_EXISTED(HttpStatus.CONFLICT, "student has been existed"),

    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "course not found"),
    COURSE_EXISTED(HttpStatus.CONFLICT, "course has been registered"),
    COURSE_REGISTERED(HttpStatus.CONFLICT, "course has been registered"),
    COURSE_REGISTERED_NOT_FOUND(HttpStatus.NOT_FOUND, "course has been unenrolled"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
