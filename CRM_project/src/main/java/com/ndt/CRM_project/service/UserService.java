package com.ndt.CRM_project.service;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


import com.ndt.CRM_project.repo.RoleRepo;
import com.ndt.CRM_project.repo.UserRepo;

import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.entity.UserEntity;


public class UserService {
    private final UserRepo userRepo = new UserRepo();

    private final RoleRepo roleRepo = new RoleRepo();


    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }


    public List<RoleEntity> getAllRoles() {
        return roleRepo.findAll();
    }


    public boolean addUser(UserEntity user) {
        return userRepo.save(user) > 0;
    }
}
