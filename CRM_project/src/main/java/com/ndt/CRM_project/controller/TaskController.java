// package com.ndt.CRM_project.controller;
//
// import com.ndt.CRM_project.entity.ProjectEntity;
// import com.ndt.CRM_project.service.ProjectService;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;
//
// import java.io.IOException;
// import java.time.LocalDate;
//
//
// @WebServlet(name = "taskController", urlPatterns = {"/task", "/task-add"})
// public class TaskController extends HttpServlet {
//     private final TaskService taskService = new TaskService();
//
//
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         String path = req.getServletPath();
//
//         switch (path) {
//             case "/task" -> {
//                 req.setAttribute("tasks", taskService.getAll());
//                 req.getRequestDispatcher("task.jsp").forward(req, resp);
//             }
//
//             case "/task-add" -> {
//                 req.getRequestDispatcher("task-add.jsp").forward(req, resp);
//             }
//         }
//     }
//
//
//     @Override
//     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         String path = req.getServletPath();
//
//         if (path.equals("/task-add")) {
//             String addMsg = "Thêm task thất bại";
//
//             TaskEntity obj = new TaskEntity();
//
//             obj.setName(req.getParameter("name"));
//             obj.setStartDate(LocalDate.parse(req.getParameter("startDate")));
//             obj.setEndDate(LocalDate.parse(req.getParameter("endDate")));
//
//             if (taskService.addTask(obj)) {
//                 addMsg = "Thêm task thành công";
//             }
//
//             // demo for using flash message (a.k.a FlashAttribute in Spring)
//             HttpSession session = req.getSession();
//             session.setAttribute("addMsg", addMsg);
//             resp.sendRedirect(req.getContextPath() + "/project-add");
//         }
//     }
// }
