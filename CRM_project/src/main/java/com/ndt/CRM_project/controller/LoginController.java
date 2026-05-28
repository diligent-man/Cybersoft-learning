package com.ndt.CRM_project.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.ndt.CRM_project.service.LoginService;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.ndt.CRM_project.service.UserService;


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
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        String result = loginService.authenticate(username, password, remember, resp);

        HttpSession session = req.getSession();
        session.setAttribute("formMsg", result);
        resp.sendRedirect("/");
    }
}
