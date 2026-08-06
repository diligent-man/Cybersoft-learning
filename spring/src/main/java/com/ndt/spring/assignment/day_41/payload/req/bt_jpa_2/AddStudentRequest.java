package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2;

import jakarta.validation.constraints.NotNull;


import lombok.Data;


import org.hibernate.validator.constraints.Length;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q1.StudentEntity;


@Data
public class AddStudentRequest {
    @Length(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String name;


    @Length(min = 1, max = 50)
    @NotNull(message = "email cannot be null")
    private String email;


    public StudentEntity toEntity() {
        StudentEntity obj = new StudentEntity();
        obj.setName(name);
        obj.setEmail(email);
        return obj;
    }
}
