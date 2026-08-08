package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;


import lombok.Data;


import org.hibernate.validator.constraints.Length;


@Data
public class AddProductReq {
    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "99999999.99")
    private BigDecimal price;
}
