package com.ndt.CRM_project.service;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.repo.UserRepo;


public class LoginService {
    private final UserRepo userRepo = new UserRepo();


    public String authenticate(
        String email,
        String password,
        String remember,
        HttpServletResponse resp
    ) {
        String msg = "Đăng nhập thất bại";
        List<UserEntity> users = userRepo.findByEmailAndPassword(email, password);

        if (!users.isEmpty()) {
            if (remember != null) {
                Cookie cEmail = new Cookie("email", email);
                Cookie cPassword = new Cookie("password", password);

                resp.addCookie(cEmail);
                resp.addCookie(cPassword);
            }

            msg = "Đăng nhập thành công";
        }
        return msg;
    }
}
