package com.ndt.spring.assignment.day_41.exception.bt_jpa_2;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q4ErrorMsg implements ErrorMsg {
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "Category not found"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}
