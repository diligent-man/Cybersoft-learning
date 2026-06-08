package com.ndt.CRM_project.controller;

import com.ndt.CRM_project.entity.ProjectEntity;
import com.ndt.CRM_project.entity.TaskEntity;
import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.service.ProjectService;
import com.ndt.CRM_project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.time.LocalDate;

import com.ndt.CRM_project.service.TaskService;
import jakarta.servlet.http.HttpSession;


@WebServlet(
    name = "taskController",
    urlPatterns = {"/task", "/task-add", "/task-update", "/task-delete"})
public class TaskController extends HttpServlet {
    private final TaskService taskService = new TaskService();

    private final UserService userService = new UserService();

    private final ProjectService projectService = new ProjectService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/task" -> {
                req.setAttribute("tasks", taskService.getAll());
                req.getRequestDispatcher("task-table.jsp").forward(req, resp);
            }

            case "/task-add" -> {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    req.setAttribute("task", session.getAttribute("task"));
                    session.removeAttribute("task");
                }

                req.setAttribute("users", userService.getAll());
                req.setAttribute("projects", projectService.getAll());
                req.getRequestDispatcher("task-add.jsp").forward(req, resp);
            }

            case "/task-update" -> {
                int taskId = Integer.parseInt(req.getParameter("taskId"));
                TaskEntity obj = taskService.getTask(taskId);

                req.setAttribute("task", obj);
                req.setAttribute("users", userService.getAll());
                req.setAttribute("projects", projectService.getAll());
                req.getRequestDispatcher("task-add.jsp").forward(req, resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/task-add" -> {
                String msg = "Thêm task thất bại";

                TaskEntity obj = new TaskEntity();

                // TODO: check setter fields
                obj.setName(req.getParameter("name"));
                obj.setStartDate(LocalDate.parse(req.getParameter("startDate")));
                obj.setEndDate(LocalDate.parse(req.getParameter("endDate")));


                if (taskService.save(obj)) {
                    msg = "Thêm task thành công";
                }

                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/task-add");
            }

            case "/task-update" -> {
                String msg = "Cập nhật task thất bại";
                TaskEntity obj = new TaskEntity();

                obj.setId(Integer.parseInt(req.getParameter("taskId")));
                obj.setName(req.getParameter("name"));
                obj.setStartDate(req.getParameter("startDate"));
                obj.setEndDate(req.getParameter("endDate"));
                obj.setUserId(Integer.parseInt(req.getParameter("userId")));
                obj.setProjectId(Integer.parseInt(req.getParameter("projectId")));
                obj.setStatusId(Integer.parseInt(req.getParameter("statusId")));

                if (taskService.update(obj)) {
                    msg = "Cập nhật task thành công";
                }

                HttpSession session = req.getSession();

                // due to redirect to /user-add, add these 2s more for loading data
                // session.setAttribute("user", user);
                // session.setAttribute("roles", roleService.getAll());
                // resp.sendRedirect(req.getContextPath() + "/user-add");

                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/task");
            }

            case "/task-delete" -> {
                String msg = "Xóa task thất bại";

                int taskId = Integer.parseInt(req.getParameter("taskId"));

                if (taskService.delete(taskId))
                    msg = "Xóa task thành công";

                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/task");
            }
        }
    }
}
