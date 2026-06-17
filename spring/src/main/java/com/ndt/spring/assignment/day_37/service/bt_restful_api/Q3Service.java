package com.ndt.spring.assignment.day_37.service.bt_restful_api;


import org.springframework.stereotype.Service;


@Service("btRestfullAPIQ3Service")
public class Q3Service {
    public Integer calculate(Integer x, Integer y, String op) {
        if (x == null || y == null) {
            return null;
        }

        return switch (op) {
            case "add" -> x + y;
            case "subtract" -> x - y;
            case "multiply" -> x * y;
            case "divide" -> (int) x / y;
            default -> null;
        };
    }
}
