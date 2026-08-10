package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q1;

import jakarta.validation.constraints.*;


import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q1.StudentEntity;


@Data
public class UpdateStudentReq {
    @Size(min = 1, max = 100)
    @NotNull(message = "name cannot be null")
    private String name;


    @Email
    @Size(min = 1, max = 100)
    @NotNull(message = "email cannot be null")
    private String email;


    @Size(min = 1, max = 100)
    @NotNull(message = "major cannot be null")
    private String major;


    public StudentEntity toEntity() {
        StudentEntity obj = new StudentEntity();
        obj.setName(name);
        obj.setEmail(email);
        obj.setMajor(major);
        return obj;
    }
}
