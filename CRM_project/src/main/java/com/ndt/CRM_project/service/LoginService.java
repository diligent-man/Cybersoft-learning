package com.ndt.CRM_project.service;

import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.repo.UserRepo;


public class LoginService {
    private final UserRepo userRepo = new UserRepo();


    public UserEntity authenticate(
        String email,
        String password,
        String remember
    ) {
        UserEntity user = userRepo.findByEmailAndPassword(email, password).orElse(null);

        if (user != null) {
            if (remember != null) {
                user.setRemember(Boolean.TRUE);  // TODO: replaace by secure token isstead
            }
        }
        return user;
    }
}
