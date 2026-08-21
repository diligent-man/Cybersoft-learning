package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q5;

import jakarta.validation.constraints.Size;


import lombok.Data;


import org.hibernate.validator.constraints.Range;


@Data
public class StudentSearchReq {
    @Size(min = 1, max = 200)
    private String name;

    @Range(min = 1, max = 99)
    private Integer ageFrom = 1;

    @Range(min = 1, max = 99)
    private Integer ageTo = 99;

    @Size(min = 1, max = 50)
    private String emailDomain;
}
