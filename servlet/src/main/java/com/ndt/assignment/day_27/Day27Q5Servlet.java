package com.ndt.assignment.day_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Arrays;
import java.util.Optional;


@WebServlet(name = "day27Q5Servlet", urlPatterns = "/assignment/day-27/q5")
public class Day27Q5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name.isBlank()){
            name = "Unknown";
        }

        String[] hobbies = Optional.ofNullable(req.getParameterValues("hobbies")).orElse(new String[]{});

        req.setAttribute("name", name);
        req.setAttribute("hobbies", hobbies.length > 0 ? Arrays.toString(hobbies) : "none");
        req.getRequestDispatcher("/assignment/day_27/q5-output.jsp").forward(req, resp);
    }
}
