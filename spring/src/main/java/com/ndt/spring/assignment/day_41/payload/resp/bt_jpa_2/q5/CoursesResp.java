package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_2.q5;

import java.util.List;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.CourseDTO;
import lombok.Data;
import lombok.Builder;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.CourseEntity;


@Data
@Builder
public class CoursesResp {
    List<CourseDTO> courses;
}
