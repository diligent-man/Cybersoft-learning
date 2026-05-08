package com.ndt.day_26_27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "readVarFromServlet", urlPatterns = "/day-26/read-var-from-servlet")
public class ReadVarFromServlet extends HttpServlet {
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        String counterColor = "cyan";

        if (counter % 2 == 0){
            counterColor = "red";
        }


        // add value to jsp
        req.setAttribute("counter", counter);
        req.setAttribute("counterColor", counterColor);
        req.getRequestDispatcher("/day_26_27/read-var-from-servlet.jsp").forward(req, resp);
    }
}
