package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q5;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;


import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.CourseEntity;


@Data
public class AddCourseReq {
    @Size(min = 1, max = 200)
    @NotNull(message = "name cannot be null")
    private String title;


    public CourseEntity toEntity() {
        CourseEntity obj = new CourseEntity();
        obj.setTitle(title);
        return obj;
    }
}
