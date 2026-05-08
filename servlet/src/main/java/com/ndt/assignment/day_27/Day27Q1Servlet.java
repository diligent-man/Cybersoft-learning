package com.ndt.assignment.day_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "day27Q1Servlet", urlPatterns = "/assignment/day-27/q1")
public class Day27Q1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer a = Integer.valueOf(req.getParameter("a"));
        Integer b = Integer.valueOf(req.getParameter("b"));
        String op = req.getParameter("op");

        var result = switch (op){
            case "+" -> a + b;
            case "-" -> a - b;
            default -> new IllegalArgumentException("Invalid value for operation").getMessage();
        };

        req.setAttribute("result", result);
        req.getRequestDispatcher("/assignment/day_27/q1-output.jsp").forward(req, resp);
    }
}
