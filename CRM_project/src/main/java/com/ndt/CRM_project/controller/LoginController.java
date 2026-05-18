package com.ndt.CRM_project.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.ndt.CRM_project.service.UserService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.ndt.CRM_project.entity.User;
import com.ndt.CRM_project.utils.MysqlConfig;


@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        String result = userService.authenticate(username, password);

        HttpSession session = req.getSession();
        session.setAttribute("formMsg", result);
        resp.sendRedirect("index.jsp");
    }
}
