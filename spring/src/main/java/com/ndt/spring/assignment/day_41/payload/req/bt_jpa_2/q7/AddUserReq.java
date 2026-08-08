package com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q7;

import jakarta.validation.constraints.*;


import lombok.Data;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q7.UserEntity;


@Data
public class AddUserReq {
    @NotBlank
    @Size(min = 6, max = 200)
    private String username;


    @Email
    @NotBlank
    @Size(min = 6, max = 200)
    private String email;

    @NotBlank
    @Size(min = 6, max = 60)
    private String password;


    public UserEntity toEntity() {
        UserEntity obj = new UserEntity();

        obj.setUsername(username);
        obj.setEmail(email);
        obj.setPassword(password);

        return obj;
    }
}
