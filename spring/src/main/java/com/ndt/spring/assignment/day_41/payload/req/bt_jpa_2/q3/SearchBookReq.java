package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q3;

import java.math.BigDecimal;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;


import org.hibernate.validator.constraints.Length;


import lombok.Data;


@Data
public class SearchBookReq {
    @Nullable
    @Length(min = 1, max = 25)
    private String author;

    @Nullable
    @DecimalMin(value = "0.0", inclusive = false, message = "must be greater than 0")
    @DecimalMax(value = "99999999.99", message = "cannot exceed 99999999.99")
    @Digits(integer = 8, fraction = 2, message = "must be up to 8 integer digits and 2 decimals")
    private BigDecimal minPrice;

    @Nullable
    @DecimalMin(value = "0.0", inclusive = false, message = "must be greater than 0")
    @DecimalMax(value = "99999999.99", message = "cannot exceed 99999999.99")
    @Digits(integer = 8, fraction = 2, message = "must be up to 8 integer digits and 2 decimals")
    private BigDecimal maxPrice;
}
