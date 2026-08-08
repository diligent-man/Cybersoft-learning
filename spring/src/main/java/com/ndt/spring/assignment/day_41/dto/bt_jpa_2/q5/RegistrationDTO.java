package com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5;

import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.RegistrationEntity;


@Data
public class RegistrationDTO {
    private String name;

    private String title;


    public static RegistrationDTO fromEntity(RegistrationEntity entity) {
        RegistrationDTO obj = new RegistrationDTO();
        obj.setName(entity.getStudent().getName());
        obj.setTitle(entity.getCourse().getTitle());
        return obj;
    }
}
