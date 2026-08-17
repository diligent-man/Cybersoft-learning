package com.ndt.spring.assignment.day_41.exception.bt_jpa_3;

import lombok.*;


import org.springframework.http.HttpStatus;


import com.ndt.spring.exception.ErrorMsg;


@Getter
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public enum Q3ErrorMsg implements ErrorMsg {
    PRODUCT_EXISTED(HttpStatus.CONFLICT, "Product existed"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),

    CATEGORY_EXISTED(HttpStatus.CONFLICT, "Category existed"),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "Category not found"),
    ;

    private final HttpStatus httpStatus;

    @ToString.Include
    private final String errorMsg;
}


