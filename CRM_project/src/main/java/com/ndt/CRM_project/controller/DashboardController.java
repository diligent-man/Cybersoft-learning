package com.ndt.CRM_project.controller;


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
    urlPatterns = {"", "/", "/index"}
)
public class DashboardController extends HttpServlet {
    private final TaskService taskService = new TaskService();

    private Long totalTask;

    private Map<String, List<TaskEntity>> taskStats = taskService.getTaskByStatus();


    @Override
    public void init() throws ServletException {
        taskStats = taskService.getTaskByStatus();
        totalTask = taskStats.values().parallelStream().mapToLong(List::size).sum();


        System.out.println(totalTask);
        System.out.println(taskStats);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("taskStats", taskStats);
        req.setAttribute("totalTask", totalTask);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
