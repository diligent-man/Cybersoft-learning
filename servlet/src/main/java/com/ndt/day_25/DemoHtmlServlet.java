package com.ndt.day_25;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;


@WebServlet(name = "demoHTMLServlet", urlPatterns = "/day-25/demo-html")
public class DemoHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // default at: /webapp dir
        req.getRequestDispatcher("/day_25/demo-html.html").forward(req, resp);
    }
}
