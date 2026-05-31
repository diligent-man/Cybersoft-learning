package com.ndt.CRM_project.controller;

import java.io.IOException;
import java.time.LocalDate;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.ndt.CRM_project.entity.ProjectEntity;
import com.ndt.CRM_project.service.ProjectService;


@WebServlet(name = "groupworkController", urlPatterns = {"/project", "/project-add"})
public class ProjectController extends HttpServlet {
    private final ProjectService projectService = new ProjectService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/project" -> {
                req.setAttribute("projects", projectService.getAll());
                req.getRequestDispatcher("project.jsp").forward(req, resp);
            }

            case "/project-add" -> {
                req.getRequestDispatcher("project-add.jsp").forward(req, resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        if (path.equals("/project-add")) {
            String addMsg = "Thêm project thất bại";

            ProjectEntity obj = new ProjectEntity();

            obj.setName(req.getParameter("name"));
            obj.setStartDate(LocalDate.parse(req.getParameter("startDate")));
            obj.setEndDate(LocalDate.parse(req.getParameter("endDate")));

            if (projectService.addProject(obj)) {
                addMsg = "Thêm project thành công";
            }

            // demo for using flash message (a.k.a FlashAttribute in Spring)
            HttpSession session = req.getSession();
            session.setAttribute("addMsg", addMsg);
            resp.sendRedirect(req.getContextPath() + "/project-add");
        }
    }
}
