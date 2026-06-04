package com.ndt.CRM_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.ndt.CRM_project.dto.UserTaskStatusCount;
import com.ndt.CRM_project.service.TaskService;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;


import com.ndt.CRM_project.service.RoleService;
import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.service.UserService;


@WebServlet(name = "userController", urlPatterns = {"/user", "/user-add", "/user-update", "/user-details"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();

    private final RoleService roleService = new RoleService();

    private final TaskService taskService = new TaskService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/user" -> {
                req.setAttribute("users", userService.getAll());
                req.getRequestDispatcher("user-table.jsp").forward(req, resp);
            }
            case "/user-add" -> {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    req.setAttribute("user", session.getAttribute("user"));
                    session.removeAttribute("user");
                }

                req.setAttribute("roles", roleService.getAll());
                req.getRequestDispatcher("user-add.jsp").forward(req, resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getServletPath();

        switch (path) {
            case "/user-add" -> {
                String addMsg = "Thêm user thất bại";

                UserEntity user = new UserEntity();

                user.setFullName(req.getParameter("fullName"));
                user.setEmail(req.getParameter("email"));
                user.setPassword(req.getParameter("password"));
                user.setPhone(req.getParameter("phone"));
                user.setRoleId(Integer.parseInt(req.getParameter("roleId")));

                if (userService.save(user)) {
                    addMsg = "Thêm user thành công";
                }

                // demo for using flash message (a.k.a FlashAttribute in Spring)
                HttpSession session = req.getSession();
                session.setAttribute("addMsg", addMsg);
                resp.sendRedirect(req.getContextPath() + "/user-add");
            }

            case "/user-update" -> {
                String isEdited = req.getParameter("isEdited");
                Integer userId = Integer.parseInt(req.getParameter("userId"));

                if (isEdited == null) {
                    UserEntity user = userService.getUserById(userId);

                    req.setAttribute("user", user);
                    req.setAttribute("roles", roleService.getAll());
                    req.getRequestDispatcher("user-add.jsp").forward(req, resp);
                } else {
                    String addMsg = "Cập nhật user thất bại";
                    UserEntity user = new UserEntity();

                    user.setId(Integer.parseInt(req.getParameter("userId")));
                    user.setFullName(req.getParameter("fullName"));
                    user.setEmail(req.getParameter("email"));
                    user.setPassword(req.getParameter("password"));
                    user.setPhone(req.getParameter("phone"));
                    user.setRoleId(Integer.parseInt(req.getParameter("roleId")));

                    if (userService.update(user)) {
                        addMsg = "Cập nhật user thành công";
                    }

                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("addMsg", addMsg);
                    session.setAttribute("roles", roleService.getAll());
                    resp.sendRedirect(req.getContextPath() + "/user-add");
                }
            }

            case "/user-details" -> {
                Integer userId = Integer.parseInt(req.getParameter("userId"));

                List<UserTaskStatusCount> userTaskStatusCountLst = taskService.getTaskByStatus(userId);

                // [
                // UserTaskStatusCount(userId=1, fullName=Nguyen Van A, email=nva@gmail.com, statusName=Ch?a b?t ??u, color=text-danger, num_task=null, numTask=1, taskIds=[5]),
                // UserTaskStatusCount(userId=1, fullName=Nguyen Van A, email=nva@gmail.com, statusName=?ang th?c hi?n, color=text-megna, num_task=null, numTask=1, taskIds=[2])
                // ]

                System.out.println(userTaskStatusCountLst);
                req.setAttribute("userTaskStatus", );
                req.getRequestDispatcher("user-details.jsp").forward(req, resp);
            }
        }
    }
}

