package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q1;

import jakarta.validation.constraints.*;


import lombok.Data;


import org.hibernate.validator.constraints.Range;


@Data
public class UpdateStudentReq {
    @Size(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String name;

    @Email
    @Size(min = 1, max = 50)
    @NotNull(message = "price cannot be null")
    private String email;

    @Range(min = 1, max = 99)
    @NotNull(message = "age cannot be null")
    private Integer age;
}
