package com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q3;

import java.math.BigDecimal;


import lombok.*;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.CourseEntity;


@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String title;

    private BigDecimal duration;


    public static CourseDTO fromEntity(CourseEntity entity) {
        CourseDTO obj = new CourseDTO();
        obj.setTitle(entity.getTitle());
        obj.setDuration(entity.getDuration());
        return obj;
    }
}
