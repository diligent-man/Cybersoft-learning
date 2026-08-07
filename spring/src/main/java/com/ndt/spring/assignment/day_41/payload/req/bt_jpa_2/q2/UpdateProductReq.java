package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.DecimalMin;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;


@Data
public class UpdateProductReq {
    @Length(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "must be greater than 0")
    @DecimalMax(value = "99999999.99", message = "cannot exceed 99999999.99")
    @Digits(integer = 8, fraction = 2, message = "must be up to 8 integer digits and 2 decimals")
    private BigDecimal price;

    @Length(max = 20000, message = "description too long")
    private String description;
}
