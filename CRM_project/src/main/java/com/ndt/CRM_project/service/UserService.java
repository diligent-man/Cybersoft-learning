package com.ndt.CRM_project.service;

import java.util.List;

import com.ndt.CRM_project.repo.UserRepo;
import com.ndt.CRM_project.entity.UserEntity;


public class UserService {
    private final UserRepo userRepo = new UserRepo();


    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }


    public boolean addUser(UserEntity user) {
        return userRepo.save(user) > 0;
    }
}
