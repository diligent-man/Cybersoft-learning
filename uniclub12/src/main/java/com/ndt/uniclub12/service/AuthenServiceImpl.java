package com.ndt.uniclub12.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.ndt.uniclub12.repo.UserRepo;
import com.ndt.uniclub12.entity.UserEntity;
import com.ndt.uniclub12.payload.request.SignInRequest;


@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;


    @Override
    public boolean doLogin(SignInRequest request) {
        boolean isSuccess = false;
        Optional<UserEntity> opUser = userRepo.findByEmail(request.getEmail());

        if (opUser.isPresent()) {
            UserEntity user = opUser.get();

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                isSuccess = true;
            }
        }
        return isSuccess;
    }
}
