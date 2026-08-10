package com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q2;

import java.math.BigDecimal;


import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2.ProductEntity;


@Data
public class ProductDTO {
    private String name;

    private BigDecimal price;


    public static ProductDTO fromEntity(ProductEntity entity) {
        ProductDTO obj = new ProductDTO();
        obj.setName(entity.getName());
        obj.setPrice(entity.getPrice());
        return obj;
    }
}
