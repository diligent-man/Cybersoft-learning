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
    private String fullname;

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
        if (fullname != null){
            if (firstName != null){
                return firstName;
            } else {
                String[] nameComponents = fullname.split(" ");
                return String.join(" ", Arrays.copyOfRange(nameComponents, 1, nameComponents.length));
            }
        }
        return null;
    }


    public String getLastName() {
        if (fullname != null){
            if (firstName != null){
                return firstName;
            } else {
                String[] nameComponents = fullname.split(" ");
                return nameComponents[0];
            }
        }
        return null;
    }
}
