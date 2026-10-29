package com.ndt.bookshop_authentication.service.contract;

import com.ndt.bookshop_authentication.payload.req.AuthReq;


public interface AuthService {
    String signIn(AuthReq authReq);
}
