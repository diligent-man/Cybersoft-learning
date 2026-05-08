package com.ndt.day_26_27;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;


@WebServlet(name = "demoJSPServlet", urlPatterns = "/day-26-27/demo-jsp")
public class DemoJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/day_26-27/demo-jsp.jsp").forward(req, resp);
    }
}
