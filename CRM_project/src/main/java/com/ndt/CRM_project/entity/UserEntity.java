package com.ndt.CRM_project.entity;


import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Integer id;

    private String fullname;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private Integer roleId;

    private String roleName;
}
