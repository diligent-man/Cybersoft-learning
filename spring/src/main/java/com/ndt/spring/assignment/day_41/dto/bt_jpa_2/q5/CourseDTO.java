package com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5;

import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.CourseEntity;


@Data
public class CourseDTO {
    private String title;


    public static CourseDTO fromEntity(CourseEntity course) {
        CourseDTO obj = new CourseDTO();
        obj.setTitle(course.getTitle());
        return obj;
    }
}
