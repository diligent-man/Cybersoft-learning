package com.ndt.assignment.day_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "day27Q4Servlet", urlPatterns = "/assignment/day-27/q4")
public class Day27Q4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");

        if (color.isBlank()) {
            color = "white";
        }

        req.setAttribute("color", color);
        req.getRequestDispatcher("/assignment/day_27/q4-output.jsp").forward(req, resp);
    }
}
