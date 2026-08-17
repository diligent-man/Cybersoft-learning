package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.q1;

import lombok.Data;
import lombok.experimental.SuperBuilder;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.StudentEntity;


@Data
@SuperBuilder
public class StudentResp {
    StudentEntity student;
}
