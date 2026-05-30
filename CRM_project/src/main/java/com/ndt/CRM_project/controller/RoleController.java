package com.ndt.CRM_project.controller;

import java.io.IOException;

import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.service.RoleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "roleController", urlPatterns = {"/role", "/role-add"})
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
                req.setAttribute("roles", roleService.getAll());
                req.getRequestDispatcher("role-add.jsp").forward(req, resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath();

        if (path.equals("/role-add")) {
            String addMsg = "Thêm role thất bại";

            RoleEntity obj = new RoleEntity();

            obj.setName(req.getParameter("name"));
            obj.setDescription(req.getParameter("description"));

            if (roleService.addRole(obj)) {
                addMsg = "Thêm role thành công";
            }

            // demo for using flash message (a.k.a FlashAttribute in Spring)
            HttpSession session = req.getSession();
            session.setAttribute("addMsg", addMsg);
            resp.sendRedirect(req.getContextPath() + "/role-add");
        }
    }
}
