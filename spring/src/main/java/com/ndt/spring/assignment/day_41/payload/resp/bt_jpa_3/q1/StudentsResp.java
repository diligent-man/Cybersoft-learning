package com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_3.q1;

import java.util.List;


import lombok.Data;
import lombok.Builder;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q1.StudentDTO;


@Data
@Builder
public class StudentsResp {
    List<StudentDTO> students;
}
