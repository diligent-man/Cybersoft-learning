package com.ndt.day_26;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "demoJSPServlet", urlPatterns = "/day-26/read-var-from-servlet")
public class ReadVarFromServlet extends HttpServlet {
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = "red";

        if (counter % 2 == 0){
            color = "cyan";
        }

        // add value to jsp
        req.setAttribute("counterColor", color);
        req.getRequestDispatcher("/day_26/read-var-from-servlet.jsp").forward(req, resp);
        // counter++;
    }
}
