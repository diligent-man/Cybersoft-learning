package com.ndt.CRM_project.controller;


import com.ndt.CRM_project.dto.TaskStatusCount;
import com.ndt.CRM_project.entity.TaskEntity;
import com.ndt.CRM_project.service.TaskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(
    name = "dashboardController",
    urlPatterns = {"/index"}
)
public class DashboardController extends HttpServlet {
    private final TaskService taskService = new TaskService();

    private Long totalTask;

    private final List<TaskStatusCount> taskStatusStats = taskService.getTaskByStatus();


    // @Override
    // public void init() throws ServletException {
    //     totalTask = taskStatusStats
    //         .parallelStream()
    //         .map(TaskStatusCount::getNumTask)
    //         .reduce(Long::sum)
    //         .orElse(1L);
    // }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setAttribute("taskStatusStats", taskStatusStats);
        // req.setAttribute("totalTask", totalTask);
        System.out.println("asdjhasbdhjasgdhjsagd");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
