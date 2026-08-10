package com.ndt.spring.assignment.day_41.exception.bt_jpa_3;

import com.ndt.spring.exception.ErrorMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q2ErrorMsg implements ErrorMsg {
    EXISTED(HttpStatus.CONFLICT, "Product existed"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
