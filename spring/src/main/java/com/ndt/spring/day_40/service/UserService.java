package com.ndt.spring.day_40.service;

import java.util.List;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import com.ndt.spring.day_40.repo.UserRepo;
import com.ndt.spring.day_40.entity.UserEntity;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;


    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
