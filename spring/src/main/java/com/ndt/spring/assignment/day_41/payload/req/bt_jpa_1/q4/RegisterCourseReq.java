package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q4;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;


@Data
public class RegisterCourseReq {
    @NotEmpty(message = "Danh sách courseId không được rỗng")
    private List<Integer> courseIds;
}
