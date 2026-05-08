package com.ndt.assignment.day_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "day27Q2Servlet", urlPatterns = "/assignment/day-27/q2")
public class Day27Q2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String prompt = "Xin chào bạn!";

        if (name != null){
            name = "null";
            prompt = String.format("Xin chào %s!", name);
        }

        req.setAttribute("name", name);
        req.setAttribute("prompt", prompt);
        req.getRequestDispatcher("/assignment/day_27/q2-output.jsp").forward(req, resp);
    }
}
