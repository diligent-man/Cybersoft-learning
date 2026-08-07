package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q2;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;


import lombok.Data;


import org.hibernate.validator.constraints.Length;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;


@Data
public class AddProductReq {
    @Length(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String name;


    @NotNull(message = "price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "must be greater than 0")
    @DecimalMax(value = "99999999.99", message = "cannot exceed 99999999.99")
    @Digits(integer = 8, fraction = 2, message = "must be up to 8 integer digits and 2 decimals")
    private BigDecimal price;

    @Length(max = 65535, message = "description must not exceed 65535 characters")
    private String description;


    public ProductEntity toEntity() {
        ProductEntity obj = new ProductEntity();
        obj.setName(name);
        obj.setPrice(price);
        obj.setDescription(description);
        return obj;
    }
}
