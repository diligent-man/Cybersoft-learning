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


    public UserEntity getUser(int id) {
        return userRepo.findById(id).orElse(null);
    }


    public boolean save(UserEntity obj) {
        return userRepo.save(obj) > 0;
    }


    public boolean update(UserEntity obj) {
        return userRepo.update(obj) > 0;
    }


    public boolean delete(int id) {
        return userRepo.deleteById(id) > 0;
    }
}
