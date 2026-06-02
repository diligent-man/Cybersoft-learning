package com.ndt.CRM_project.controller;

import java.util.List;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.ndt.CRM_project.dto.TaskStatusCount;
import com.ndt.CRM_project.service.TaskService;


@WebServlet(
    name = "dashboardController",
    urlPatterns = {
        // "/" urlPattern must not be specified cuz server container use it to serve static resources
        "",
        "/index",
        "/home", "/dashboard"
    }
)
public class DashboardController extends HttpServlet {
    private final TaskService taskService = new TaskService();

    private Long totalTask;

    private final List<TaskStatusCount> taskStatusStats = taskService.getTaskByStatus();


    @Override
    public void init() throws ServletException {
        totalTask = taskStatusStats
            .parallelStream()
            .map(TaskStatusCount::getNumTask)
            .reduce(Long::sum)
            .orElse(1L);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("taskStatusStats", taskStatusStats);
        req.setAttribute("totalTask", totalTask);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
