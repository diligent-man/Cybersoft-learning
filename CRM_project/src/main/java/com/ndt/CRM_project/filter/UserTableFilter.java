package com.ndt.CRM_project.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(
    filterName = "userTableFilter",
    urlPatterns = {"/user", "/user-add"}
)
public class UserTableFilter extends HttpFilter {
    private final Set<String> ALLOWED_VIEW_ROLES = new HashSet<>(List.of("manager", "admin"));

    private final Set<String> ALLOWED_MOD_ROLES = new HashSet<>(List.of("admin"));


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /* Note: doFilter chain chỉ được chạy 1 lần và code sau filter chain sẽ không được chạy
          -> response has been commited error
        */
        String role = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("role"))
                    role = cookie.getValue();

        if (role != null) {
            String path = req.getServletPath();

            if (path.equals("/") && ALLOWED_VIEW_ROLES.contains(role)) {
                chain.doFilter(req, res);
            } else if (path.equals("/user") && ALLOWED_VIEW_ROLES.contains(role)) {
                chain.doFilter(req, res);
            } else if (path.equals("/user-add") && ALLOWED_MOD_ROLES.contains(role)) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
