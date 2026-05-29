package com.ndt.CRM_project.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.ndt.CRM_project.service.LoginService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.ndt.CRM_project.entity.UserEntity;


@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    LoginService loginService = new LoginService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = null;
        String password = null;

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email"))
                    email = cookie.getValue();

                if (cookie.getName().equals("password"))
                    password = cookie.getValue();
            }
        }

        req.setAttribute("email", email);
        req.setAttribute("password", password);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        UserEntity user = loginService.authenticate(email, password, remember);

        String msg = "Đăng nhập thất bại";
        HttpSession session = req.getSession();

        if (user != null) {
            msg = "Đăng nhập thành công";
            Cookie cRole = new Cookie("role", user.getRoleName());

            if (remember != null && user.getRemember()) {
                Cookie cEmail = new Cookie("email", email);
                Cookie cPassword = new Cookie("password", password);

                resp.addCookie(cEmail);
                resp.addCookie(cPassword);
            }

            resp.addCookie(cRole);
        }

        session.setAttribute("formMsg", msg);

        resp.addCookie(new Cookie("remember", remember));
        resp.sendRedirect("/");
    }
}
