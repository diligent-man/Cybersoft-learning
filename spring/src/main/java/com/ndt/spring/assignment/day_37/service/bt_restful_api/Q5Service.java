package com.ndt.spring.assignment.day_37.service.bt_restful_api;

import java.util.*;


import jakarta.annotation.PostConstruct;


import lombok.Getter;

import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_37.entity.bt_restful_api.Q5StudentEntity;


@Service("btRestfullAPIQ5Service")
public class Q5Service {
    // Fake data cuz not have repo
    @Getter
    private final List<Q5StudentEntity> students = new ArrayList<>();


    @PostConstruct
    public void init() {
        Q5StudentEntity student = new Q5StudentEntity(1, "Nguyen Van A", "nva@gmail.com");
        students.add(student);

        student = new Q5StudentEntity(1, "Nguyen Van B", "nvb@gmail.com");
        students.add(student);
    }


    public Optional<Q5StudentEntity> getStudent(int id) {
        return students.stream().filter(ele -> ele.getId().equals(id)).findFirst();
    }


    public boolean addStudent(Q5StudentEntity student) {
        // data validation is on repo not here !
        return students.add(student);
    }
}
