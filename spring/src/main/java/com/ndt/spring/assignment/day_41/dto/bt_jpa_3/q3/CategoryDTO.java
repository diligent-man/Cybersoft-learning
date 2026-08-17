package com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q3;

import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3.CategoryEntity;


@Data
public class CategoryDTO {
    private String name;


    public static CategoryDTO fromEntity(CategoryEntity entity) {
        CategoryDTO obj = new CategoryDTO();
        obj.setName(entity.getName());
        return obj;
    }
}
