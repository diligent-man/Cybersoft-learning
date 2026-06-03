package com.ndt.CRM_project.entity;


import lombok.*;

import java.util.Arrays;


@Setter
@ToString
@NoArgsConstructor
public class UserEntity {
    @Getter
    private Integer id;

    @Getter
    private String fullName;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String phone;

    @Getter
    private Integer roleId;

    @Getter
    private String roleName;

    private String firstName;

    private String lastName;

    @Getter
    private Boolean remember;


    public String getFirstName() {
        if (fullName != null){
            if (firstName != null){
                return firstName;
            } else {
                String[] nameComponents = fullName.split(" ");
                return String.join(" ", Arrays.copyOfRange(nameComponents, 1, nameComponents.length));
            }
        }
        return null;
    }


    public String getLastName() {
        if (fullName != null){
            if (lastName != null){
                return lastName;
            } else {
                String[] nameComponents = fullName.split(" ");
                return nameComponents[0];
            }
        }
        return null;
    }
}
