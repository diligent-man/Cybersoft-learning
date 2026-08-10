package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q2;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;


import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2.ProductEntity;


@Data
public class AddProductReq {
    @Size(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String name;

    @Digits(integer = 8, fraction = 2)
    @DecimalMin("0.0")
    @DecimalMax("99999999.99")
    @NotNull(message = "price cannot be null")
    private BigDecimal price;


    @Size(min = 1, max = 65555)
    private String description;


    public ProductEntity toEntity() {
        ProductEntity obj = new ProductEntity();
        obj.setName(name);
        obj.setPrice(price);
        obj.setDescription(description);
        return obj;
    }
}
