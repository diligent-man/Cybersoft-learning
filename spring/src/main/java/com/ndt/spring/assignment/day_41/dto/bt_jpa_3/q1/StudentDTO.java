package com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q1;

import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q1.StudentEntity;


@Data
public class StudentDTO {
    private String name;

    private String major;


    public static StudentDTO fromEntity(StudentEntity entity) {
        StudentDTO obj = new StudentDTO();
        obj.setName(entity.getName());
        obj.setMajor(entity.getMajor());
        return obj;
    }
}
