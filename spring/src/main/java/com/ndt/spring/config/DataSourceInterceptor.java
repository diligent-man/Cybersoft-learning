package com.ndt.spring.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class DataSourceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) {
        String uri = request.getRequestURI();

        if (uri.startsWith("/assignment/day_41/jpa1/q1")) {
            DataSourceContextHolder.set(DatabaseType.JPA1Q1);
        } else if (uri.startsWith("/assignment/day_41/jpa1/q2")) {
            DataSourceContextHolder.set(DatabaseType.JPA1Q2);
        }

        return true;
    }


    @Override
    public void afterCompletion(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        Exception ex
    ) {
        DataSourceContextHolder.clear();
    }
}