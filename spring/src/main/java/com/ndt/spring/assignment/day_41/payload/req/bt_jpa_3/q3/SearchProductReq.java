package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q3;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;


import lombok.Data;


@Data
public class SearchProductReq {
    @Positive
    @Nullable
    private Integer categoryId;
}
