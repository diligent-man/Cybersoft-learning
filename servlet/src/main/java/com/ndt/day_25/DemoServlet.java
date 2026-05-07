package com.ndt.day_25;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;


// Tạo ra servlet tên là demoServlet, code sẽ được chạy khi client gọi /demo
@WebServlet(name = "demoServlet", urlPatterns = "/day-25/demo")
public class DemoServlet extends HttpServlet {
    // là nơi xử lý logic code khi có request method là GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.append("Hello Java bootcamp 12");
        out.close();
    }
}
