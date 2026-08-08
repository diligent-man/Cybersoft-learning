package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import com.ndt.spring.exception.ErrorMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q7ErrorMsg implements ErrorMsg {
    USER_EXISTED(HttpStatus.BAD_REQUEST, "User existed");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
