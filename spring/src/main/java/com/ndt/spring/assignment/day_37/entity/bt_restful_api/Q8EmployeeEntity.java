package com.ndt.spring.assignment.day_37.entity.bt_restful_api;


import lombok.*;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Q8EmployeeEntity {
    private Integer id;

    @Setter
    private String fullName;

    @Setter
    private String email;
}
