package com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q5;

import lombok.*;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5.StudentEntity;


@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String name;

    private Integer age;

    private String email;


    public static StudentDTO fromEntity(StudentEntity entity) {
        StudentDTO obj = new StudentDTO();
        obj.setName(entity.getName());
        obj.setAge(entity.getAge());
        obj.setEmail(entity.getEmail());
        return obj;
    }
}
