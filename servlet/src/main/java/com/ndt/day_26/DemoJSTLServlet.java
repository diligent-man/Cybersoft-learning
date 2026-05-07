package com.ndt.day_26;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "demoJSTLServlet", urlPatterns = "/day-26/demo-jstl")
public class DemoJSTLServlet extends HttpServlet {
    private List<String> strArr = new ArrayList<>(List.of(new String[]{"a", "b", "c"}));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("strArr", strArr);
        req.getRequestDispatcher("/day_26/demo-jstl.jsp").forward(req, resp);
    }
}
