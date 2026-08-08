package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q5ErrorMsg implements ErrorMsg {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Student not found"),
    STUDENT_EXISTED(HttpStatus.CONFLICT, "Student name existed"),

    COURSE_NOT_FOUND(HttpStatus.NOT_FOUND, "Course not found"),
    COURSE_EXISTED(HttpStatus.CONFLICT, "Course name existed"),
    COURSE_REGISTERED(HttpStatus.BAD_REQUEST, "Course has been registered"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
