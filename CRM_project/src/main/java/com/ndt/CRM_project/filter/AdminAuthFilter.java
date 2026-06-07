package com.ndt.CRM_project.filter;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    urlPatterns = {
        "", "/",
        "/index", "/index.jsp", "/index.html",
        "/dashboard", "/home"
    },
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
                String path = req.getServletPath();

                if (path.startsWith("/index.")) {
                    res.sendRedirect(req.getContextPath() + "/");
                } else {
                    chain.doFilter(req, res);
                }
            } else {
                for (Cookie cookie : cookies)
                    if (cookie.getName().equals("loginMsg")) {
                        String loginMsg = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);

                        cookie.setValue(URLEncoder.encode(
                            loginMsg.concat(String.format(" Tuy nhiên role (%s) này không được phép vào !", role)),
                            StandardCharsets.UTF_8)
                        );
                        res.addCookie(cookie);
                        break;
                    }
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
