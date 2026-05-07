package com.ndt.day_26;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "paramPassingServlet", urlPatterns = "/day-26/param-passing")
public class ParamPassingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null) {
            req.getRequestDispatcher("/day_26/param-passing-form.jsp").forward(req, resp);
        } else {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.getRequestDispatcher("/day_26/param-passing.jsp").forward(req, resp);
        }
    }
}
