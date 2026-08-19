package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2;

import java.util.List;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q2.StudentRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.StudentEntity;


@RequiredArgsConstructor
@Service("btJPA1Q2StudentService")
public class StudentService {
    @Qualifier("btJPA1Q2StudentRepo")
    private final StudentRepo studentRepo;


    public List<StudentEntity> getAll() {
        return studentRepo.findAll();
    }


    public List<StudentEntity> search(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name);
    }
}
