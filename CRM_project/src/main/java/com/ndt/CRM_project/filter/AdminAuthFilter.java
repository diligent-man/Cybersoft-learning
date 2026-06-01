package com.ndt.CRM_project.filter;

import java.util.*;
import java.io.IOException;


import jakarta.servlet.FilterChain;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebFilter;


@WebFilter(
    filterName = "adminAuthFilter",
    urlPatterns = {"/index.*"},
    dispatcherTypes = {DispatcherType.REQUEST}  // activate on REQUEST http only
)
public class AdminAuthFilter extends HttpFilter {
    private final Set<String> ALLOWED_ROLES = new HashSet<>(List.of("manager", "admin"));


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String role = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("role"))
                    role = cookie.getValue();

        if (role != null) {
            if (ALLOWED_ROLES.contains(role)) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
