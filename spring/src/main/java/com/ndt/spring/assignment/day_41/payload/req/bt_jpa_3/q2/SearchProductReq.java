package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q2;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;


import lombok.Data;


@Data
public class SearchProductReq {
    @Nullable
    @Size(min = 1, max = 200)
    private String name;
}
