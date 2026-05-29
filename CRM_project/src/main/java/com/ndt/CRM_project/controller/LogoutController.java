package com.ndt.CRM_project.controller;

import java.util.*;
import java.io.IOException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;



@WebServlet(name = "logoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private final Set<String> DEFAULT_COOKIES_TO_REMOVE = new HashSet<>(List.of("role", "loginMsg", "remember"));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Step 1: invalidate session
        // Do not create a new session if one doesn't exist
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Step 2: remove cookiee
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Set<String> COOKIES_TO_REMOVE = new HashSet<>(DEFAULT_COOKIES_TO_REMOVE);

            boolean removeCredential = Arrays.stream(cookies)
                .parallel()
                .anyMatch(cookie -> cookie.getName().equals("remember") && cookie.getValue().isEmpty());

            if (removeCredential) {
                COOKIES_TO_REMOVE.add("email");
                COOKIES_TO_REMOVE.add("password");
            } else {
                COOKIES_TO_REMOVE.remove("remember");
            }

            for (Cookie cookie : cookies) {
                if (COOKIES_TO_REMOVE.contains(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setPath(req.getContextPath()); // Must match the original path
                    cookie.setMaxAge(0); // delete immediately
                    resp.addCookie(cookie);  // send back to resp to overwrite
                }
            }
        }
        resp.sendRedirect("/");
    }
}
