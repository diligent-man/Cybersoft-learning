package com.ndt.spring.assignment.day_41.exception.bt_jpa_1;

import com.ndt.spring.exception.ErrorMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q4ErrorMsg implements ErrorMsg {
    NOT_FOUND(HttpStatus.NOT_FOUND, "not found");

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
