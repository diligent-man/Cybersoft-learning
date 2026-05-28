package com.ndt.CRM_project.controller;

import java.io.IOException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.service.UserService;


@WebServlet(name = "userController", urlPatterns = {"/user", "/user-add"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/user")) {
            req.setAttribute("users", userService.getAll());
            req.getRequestDispatcher("user-table.jsp").forward(req, resp);
        } else if (path.equals("/user-add")) {
            req.setAttribute("roles", userService.getAllRoles());
            req.getRequestDispatcher("user-add.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/user-add")) {
            UserEntity user = new UserEntity();

            user.setFullname(req.getParameter("fullName"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setPhone(req.getParameter("phone"));
            user.setRoleId(Integer.parseInt(req.getParameter("roleId")));

            req.getRequestDispatcher("user-add.jsp").forward(req, resp);
        }
    }
}
