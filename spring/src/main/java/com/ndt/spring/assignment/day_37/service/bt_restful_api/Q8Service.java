package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.*;

import jakarta.annotation.PostConstruct;


import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q8EmployeeEntity;


@Service("btRestfullAPIQ8Service")
public class Q8Service {
    // Fake data cuz not have repo
    private final List<Q8EmployeeEntity> employeeLst = new ArrayList<>();


    @PostConstruct
    public void init() {
        // Implement unidirection from author POV
        String[] employeeNames = new String[]{
            "Nguyen Van A",
            "Nguyen Van C",
            "Nguyen Van D",
            "Nguyen Van E"
        };

        String[] employeeEmails = new String[]{
            "nva@gmail.com",
            "nvb@gmail.com",
            "nvd@gmail.com",
            "nve@gmail.com"
        };

        for (int i = 0; i < employeeNames.length; i++) {
            Q8EmployeeEntity employee = new Q8EmployeeEntity(i + 1, employeeNames[i], employeeEmails[i]);
            employeeLst.add(employee);
        }
    }


    public Optional<Q8EmployeeEntity> getEmployee(int id) {
        return employeeLst.stream()
            .filter(ele -> ele.getId().equals(id))
            .findFirst();
    }
}
