package com.ndt.spring.day_36_37_38_39.request;

import lombok.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRequest {
    private String id;

    private String username;

    private String password;
}
