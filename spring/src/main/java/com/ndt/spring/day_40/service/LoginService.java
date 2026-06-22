package com.ndt.spring.day_40.service;

import java.util.Optional;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import com.ndt.spring.day_40.repo.UserRepo;
import com.ndt.spring.day_40.entity.UserEntity;


@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepo userRepo;


    public boolean authenticate(String email, String password) {
        boolean isSuccess = false;

        // UserEntity userEntity = userRepo.findByEmailAndPassword(email, password);
        Optional<UserEntity> opUserEntity = userRepo.kiemTraEmailPassword(email, password);

        // .get(): trả về giá trị được Optional wrap
        // .ifPresent(): true nếu có UserEntity trả về -> chắc chắn k null
        if (opUserEntity.isPresent()) {
            isSuccess = true;
        }

        return isSuccess;
    }
}
