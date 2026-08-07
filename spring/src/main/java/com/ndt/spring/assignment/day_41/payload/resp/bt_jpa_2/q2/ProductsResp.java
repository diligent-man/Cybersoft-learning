package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q2;

import java.util.List;


import lombok.Data;
import lombok.experimental.SuperBuilder;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;


@Data
@SuperBuilder
public class ProductsResp {
    private final List<ProductEntity> products;
}
