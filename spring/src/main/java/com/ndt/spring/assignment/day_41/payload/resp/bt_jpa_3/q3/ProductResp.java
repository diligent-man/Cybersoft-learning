package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_3.q3;

import lombok.Data;
import lombok.Builder;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q3.ProductDTO;


@Data
@Builder
public class ProductResp {
    ProductDTO product;
}
