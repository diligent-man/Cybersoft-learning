package com.ndt.uniclub12.service;

import com.ndt.uniclub12.payload.request.SignInRequest;


public interface AuthenService {
    boolean doLogin(SignInRequest request);
}
