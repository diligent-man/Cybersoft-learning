package com.ndt.CRM_project.controller;

import java.io.IOException;


import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;


import com.ndt.CRM_project.entity.UserEntity;

import com.ndt.CRM_project.service.RoleService;
import com.ndt.CRM_project.service.UserService;
import com.ndt.CRM_project.service.TaskService;

import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;


@WebServlet(
    name = "userController",
    urlPatterns = {"/user", "/user-add", "/user-update", "/user-fetch", "/user-delete", "/user-details"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserService();

    private final RoleService roleService = new RoleService();

    private final TaskService taskService = new TaskService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/user" -> {
                req.setAttribute("users", userService.getAll());  // for server-side rendering only
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


            case "/user-update" -> {
                int userId = Integer.parseInt(req.getParameter("userId"));
                UserEntity obj = userService.getUser(userId);

                req.setAttribute("user", obj);
                req.setAttribute("roles", roleService.getAll());
                req.getRequestDispatcher("user-add.jsp").forward(req, resp);
            }

            case "/user-details" -> {
                int userId = Integer.parseInt(req.getParameter("userId"));
                UserTaskStatusStatsDTO userTaskStatusStats = taskService.getTaskByUserStatus(userId);

                req.setAttribute("statusLst", userTaskStatusStats.getTaskStatusMap().keySet());
                req.setAttribute("userTaskStatusStats", userTaskStatusStats);
                req.getRequestDispatcher("user-details.jsp").forward(req, resp);
            }

            // case "/fetch-user" -> {
            //     int page = 1;
            //     int pageSize = 10;
            //
            //     try {
            //         String pageParam = req.getParameter("page");
            //         String pageSizeParam = req.getParameter("pageSize");
            //
            //         if (pageParam != null)
            //             page = Integer.parseInt(pageParam);
            //
            //         if (pageSizeParam != null)
            //             pageSize = Integer.parseInt(pageSizeParam);
            //     } catch (NumberFormatException e) {
            //         //
            //     }
            //
            //     List<Integer> allowedSizes = List.of(10, 25, 50, 100);
            //     if (!allowedSizes.contains(pageSize))
            //         pageSize = 10;
            //
            //
            //     List<UserEntity> users = userService.getUsersPaged(page, pageSize);
            //     int totalItems = userService.getAll().size();
            //     // int totalItems = userService.countAllUsers();
            //
            //     PageDTO<UserEntity> pageDTO = new PageDTO<>(users, page, pageSize, totalItems);
            //
            //     ObjectMapper mapper = new ObjectMapper();
            //     String json = mapper.writeValueAsString(pageDTO);
            //
            //     resp.setContentType("application/json");
            //     resp.setCharacterEncoding("UTF-8");
            //     resp.getWriter().write(json);
            // }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = req.getServletPath();

        switch (path) {
            case "/user-add" -> {
                String msg = "Thêm user thất bại";

                UserEntity user = new UserEntity();

                user.setFullName(req.getParameter("fullName"));
                user.setEmail(req.getParameter("email"));
                user.setPassword(req.getParameter("password"));
                user.setPhone(req.getParameter("phone"));
                user.setRoleId(Integer.parseInt(req.getParameter("roleId")));

                if (userService.save(user)) {
                    msg = "Thêm user thành công";
                }

                // demo for using flash message (a.k.a FlashAttribute in Spring)
                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/user-add");
            }

            case "/user-update" -> {
                String msg = "Cập nhật user thất bại";
                UserEntity obj = new UserEntity();

                obj.setId(Integer.parseInt(req.getParameter("userId")));
                obj.setFullName(req.getParameter("fullName"));
                obj.setEmail(req.getParameter("email"));
                obj.setPassword(req.getParameter("password"));
                obj.setPhone(req.getParameter("phone"));
                obj.setRoleId(Integer.parseInt(req.getParameter("roleId")));

                if (userService.update(obj)) {
                    msg = "Cập nhật user thành công";
                }

                HttpSession session = req.getSession();

                // due to redirect to /user-add, add these 2s more for loading data
                // session.setAttribute("user", user);
                // session.setAttribute("roles", roleService.getAll());
                // resp.sendRedirect(req.getContextPath() + "/user-add");

                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/user");
            }

            case "/user-delete" -> {
                // TODO: add on delete cascade ?
                String msg = "Xóa user thất bại";

                int userId = Integer.parseInt(req.getParameter("userId"));

                if (userService.delete(userId))
                    msg = "Xóa user thành công";

                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/user");
            }
        }
    }
}
