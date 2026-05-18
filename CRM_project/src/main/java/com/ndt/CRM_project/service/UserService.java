package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.entity.User;
import com.ndt.CRM_project.repo.UserRepo;


public class UserService {
    private final UserRepo userRepo = new UserRepo();


    public List<User> getAll() {
        return userRepo.findAll();
    }


    public String authenticate(String username, String password) {
        List<User> users = userRepo.findUserByEmailAndPassword(username, password);
        return !users.isEmpty() ? "Thanh cong" : "Dang nhap that bai";
    }
}
