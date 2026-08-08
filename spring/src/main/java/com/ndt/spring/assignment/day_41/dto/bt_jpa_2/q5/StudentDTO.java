package com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5;

import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.StudentEntity;


@Data
public class StudentDTO {
    private String name;


    public static StudentDTO fromEntity(StudentEntity student) {
        StudentDTO obj = new StudentDTO();
        obj.setName(student.getName());
        return obj;
    }
}
