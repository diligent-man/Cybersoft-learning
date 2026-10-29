package com.ndt.bookshop_authentication.payload.req;

import lombok.Data;


@Data
public class AuthReq {
    private String email;

    private String password;
}
