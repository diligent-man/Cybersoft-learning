package com.ndt.CRM_project.service;

import com.ndt.CRM_project.repo.UserRepo;
import com.ndt.CRM_project.entity.UserEntity;


public class LoginService {
    private final UserRepo userRepo = new UserRepo();


    public UserEntity authenticate(
        String email,
        String password,
        String remember
    ) {
        if (email.isEmpty() || password.isEmpty())
            return null;

        UserEntity user = userRepo.findByEmail(email).orElse(null);
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                return null;
            }

            // TODO: replace by secure token instead
            if (remember != null) {
                user.setRemember(Boolean.TRUE);
            }
        }
        return user;
    }
}
