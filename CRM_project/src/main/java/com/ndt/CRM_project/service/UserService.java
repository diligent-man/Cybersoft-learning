package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.repo.UserRepo;
import com.ndt.CRM_project.entity.UserEntity;


public class UserService {
    private final UserRepo userRepo = new UserRepo();


    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }


    public List<UserEntity> getUsersPaged(int page, int pageSize) {
        return userRepo.findByOffset(page, pageSize);
    }


    public UserEntity getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }


    public boolean save(UserEntity user) {
        return userRepo.save(user) > 0;
    }


    public boolean update(UserEntity user) {
        return userRepo.update(user) > 0;
    }


    public boolean delete(int id) {
        return userRepo.deleteById(id) > 0;
    }
}
