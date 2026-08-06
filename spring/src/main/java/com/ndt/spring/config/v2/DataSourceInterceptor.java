package com.ndt.spring.config.v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.jspecify.annotations.NonNull;


import org.springframework.web.servlet.HandlerInterceptor;


public class DataSourceInterceptor implements HandlerInterceptor {
    private static final Pattern DB_URI_PATTERN = Pattern.compile("/assignment/day_41/jpa(\\d+)/q(\\d+)");


    @Override
    public boolean preHandle(
        HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull Object handler
    ) {
        String uri = request.getRequestURI();
        Matcher matcher = DB_URI_PATTERN.matcher(uri);

        if (matcher.find()) {
            String enumName = "JPA" + matcher.group(1) + "Q" + matcher.group(2);

            try {
                DataSourceContextHolder.set(DatabaseType.valueOf(enumName));
            } catch (IllegalArgumentException e) {
                System.out.println("no matching DatabaseType enum constant");
            }
        }
        return true;
    }


    @Override
    public void afterCompletion(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull Object handler,
        Exception ex
    ) {
        DataSourceContextHolder.clear();
    }
}