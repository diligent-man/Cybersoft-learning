package com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q4;

import java.util.Set;


import lombok.*;



@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private String name;
    private Set<CourseDTO> courses;
}
