package com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q3;

import java.time.LocalDate;


import lombok.*;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.RegistrationEntity;


@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private Integer studentId;

    private Integer courseId;

    private LocalDate registrationDate;


    public static RegistrationDTO fromEntity(RegistrationEntity entity) {
        RegistrationDTO obj = new RegistrationDTO();
        obj.setStudentId(entity.getStudent().getId());
        obj.setCourseId(entity.getCourse().getId());
        obj.setRegistrationDate(entity.getRegistrationDate());
        return obj;
    }
}