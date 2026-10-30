package com.ndt.bookshop_authentication.service.impl;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.ndt.bookshop_authentication.entity.Users;
import com.ndt.bookshop_authentication.repo.UserRepo;
import com.ndt.bookshop_authentication.payload.req.AuthReq;
import com.ndt.bookshop_authentication.exception.DataNotFound;
import com.ndt.bookshop_authentication.service.contract.JwtService;
import com.ndt.bookshop_authentication.service.contract.AuthService;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public String signIn(AuthReq authReq) {
        Users user = userRepo
            .findByEmail(authReq.getEmail())
            .orElseThrow(() -> new DataNotFound("User not found"));

        if (!passwordEncoder.matches(authReq.getPassword(), user.getPassword())) {
            throw new DataNotFound("Invalid password");
        } else {
            return jwtService.genAccessToken(authReq.getEmail());
        }
    }
}
