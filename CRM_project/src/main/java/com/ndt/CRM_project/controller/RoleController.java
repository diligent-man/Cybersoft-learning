package com.ndt.CRM_project.controller;

import java.io.IOException;


import com.ndt.CRM_project.entity.UserEntity;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;


import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.service.RoleService;


@WebServlet(
    name = "roleController",
    urlPatterns = {"/role", "/role-add", "/role-update", "/role-delete"}
)
public class RoleController extends HttpServlet {
    private final RoleService roleService = new RoleService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/role" -> {
                req.setAttribute("roles", roleService.getAll());
                req.getRequestDispatcher("role-table.jsp").forward(req, resp);
            }

            case "/role-add" -> {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    req.setAttribute("role", session.getAttribute("role"));
                    session.removeAttribute("role");
                }

                req.getRequestDispatcher("role-add.jsp").forward(req, resp);
            }

            case "/role-update" -> {
                int roleId = Integer.parseInt(req.getParameter("roleId"));
                RoleEntity obj = roleService.getRoleById(roleId);

                req.setAttribute("role", obj);
                req.getRequestDispatcher("role-add.jsp").forward(req, resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/role-add" -> {
                String msg = "Thêm role thất bại";

                RoleEntity obj = new RoleEntity();

                obj.setName(req.getParameter("name"));
                obj.setDescription(req.getParameter("description"));

                if (roleService.addRole(obj)) {
                    msg = "Thêm role thành công";
                }

                HttpSession session = req.getSession();
                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/role-add");
            }

            case "/role-update" -> {
                String msg = "Cập nhật role thất bại";
                RoleEntity obj = new RoleEntity();

                obj.setId(Integer.parseInt(req.getParameter("id")));
                obj.setName(req.getParameter("name"));
                obj.setDescription(req.getParameter("description"));

                if (roleService.update(obj)) {
                    msg = "Cập nhật role thành công";
                }

                HttpSession session = req.getSession();

                // due to redirect to /role-add, add these 2s more for loading data
                // session.setAttribute("role", obj);
                // resp.sendRedirect(req.getContextPath() + "/role-add");

                session.setAttribute("msg", msg);
                resp.sendRedirect(req.getContextPath() + "/role");
            }
        }
    }
}
