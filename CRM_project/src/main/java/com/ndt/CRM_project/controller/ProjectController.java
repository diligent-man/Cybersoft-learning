package com.ndt.CRM_project.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.ndt.CRM_project.entity.ProjectEntity;
import com.ndt.CRM_project.service.ProjectService;


@WebServlet(
    name = "groupworkController",
    urlPatterns = {"/project", "/project-add", "/project-update", "/project-details", "/project-delete"})
public class ProjectController extends HttpServlet {
    private final ProjectService projectService = new ProjectService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/project" -> {
                req.setAttribute("projects", projectService.getAll());
                req.getRequestDispatcher("project-table.jsp").forward(req, resp);
            }

            case "/project-add" -> {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    req.setAttribute("project", session.getAttribute("project"));
                    session.removeAttribute("project");
                }

                req.getRequestDispatcher("project-add.jsp").forward(req, resp);
            }

            case "/project-update" -> {
                int projectId = Integer.parseInt(req.getParameter("projectId"));
                ProjectEntity obj = projectService.getProject(projectId);

                System.out.println(obj);

                req.setAttribute("project", obj);
                req.getRequestDispatcher("project-add.jsp").forward(req, resp);
            }

            case "/project-details" -> {
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/project-add" -> {
                String msg = "Thêm project thất bại";

                ProjectEntity obj = new ProjectEntity();

                obj.setName(req.getParameter("name"));
                obj.setStartDate(LocalDate.parse(req.getParameter("startDate")));
                obj.setEndDate(LocalDate.parse(req.getParameter("endDate")));

                if (projectService.save(obj)) {
                    msg = "Thêm project thành công";
                }

                // demo for using flash message (a.k.a FlashAttribute in Spring)
                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/project-add");
            }

            case "/project-update" -> {
                String msg = "Cập nhật project thất bại";
                ProjectEntity obj = new ProjectEntity();

                obj.setId(Integer.parseInt(req.getParameter("projectId")));
                obj.setName(req.getParameter("name"));
                obj.setStartDate(req.getParameter("startDate"));
                obj.setEndDate(req.getParameter("endDate"));

                if (projectService.update(obj)) {
                    msg = "Cập nhật project thành công";
                }

                HttpSession session = req.getSession();

                // due to redirect to /porject-add, add these more for loading data
                // session.setAttribute("project", obj);
                // resp.sendRedirect(req.getContextPath() + "/project-add");

                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/project");
            }

            case "/project-delete" -> {
                // TODO: add on delete cascade ?
                String msg = "Xóa project thất bại";

                int projectId = Integer.parseInt(req.getParameter("projectId"));

                if (projectService.delete(projectId))
                    msg = "Xóa project thành công";

                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/project");
            }
        }
    }
}
