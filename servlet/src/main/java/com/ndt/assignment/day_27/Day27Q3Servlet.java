package com.ndt.assignment.day_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "day27Q3Servlet", urlPatterns = "/assignment/day-27/q3")
public class Day27Q3Servlet extends HttpServlet {
    private String correctUsername = "admin";
    private String correctPassword = "123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = Optional.ofNullable(req.getParameter("username")).orElse("");
        String password = Optional.ofNullable(req.getParameter("password")).orElse("");

        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.setAttribute("result", username.equals(correctUsername) && password.equals(correctPassword));
        req.getRequestDispatcher("/assignment/day_27/q3-output.jsp").forward(req, resp);
    }
}
