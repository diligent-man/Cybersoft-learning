package com.ndt.CRM_project.entity;


import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserEntity {
    private Integer id;

    private String fullname;

    private String email;

    private String password;

    private String phone;

    private Integer roleId;

    private String roleName;

    private String firstName;

    private String lastName;

    private Boolean remember;
}
