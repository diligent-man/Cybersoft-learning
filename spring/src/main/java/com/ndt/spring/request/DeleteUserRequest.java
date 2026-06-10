package com.ndt.spring.request;

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
