package com.ndt.CRM_project.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/user", "/user-add"})
public class AuthenticationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        /* Note: doFilter chain chỉ được chạy 1 lần và code sau filter chain sẽ không được chạy
        * -> response has been commited */
        String role = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("role"))
                    role = cookie.getValue();

        if (role != null){
            String path  = req.getServletPath();

            if (path.equals("/user-add") && role.equals("admin")){
                chain.doFilter(req, res);
            } else if (path.equals("/user")) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
