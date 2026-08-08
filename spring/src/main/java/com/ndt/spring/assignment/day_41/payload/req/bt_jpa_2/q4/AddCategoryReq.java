package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q4;

import jakarta.validation.constraints.NotNull;


import lombok.Data;


import org.hibernate.validator.constraints.Length;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;


@Data
public class AddCategoryReq {
    @NotNull
    @Length(min = 1, max = 200)
    private String name;


    public CategoryEntity toEntity() {
        CategoryEntity obj = new CategoryEntity();
        obj.setName(name);
        return obj;
    }
}
