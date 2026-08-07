package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q1;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.exception.GenericErrorMsg;
import com.ndt.spring.exception.GenericException;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q1.StudentRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q1.StudentEntity;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q1.AddStudentReq;


@RequiredArgsConstructor
@Service("btJPA2Q1StudentService")
public class StudentService {
    @Qualifier("btJPA2Q1StudentRepo")
    private final StudentRepo studentRepo;


    public List<StudentEntity> getAll() {
        return studentRepo.findAll();
    }


    public StudentEntity save(AddStudentReq req) {
        if (studentRepo.existsByEmail(req.getEmail())) {
            throw new GenericException(GenericErrorMsg.CONFLICT, "Email '" + req.getEmail() + "' is already registered");
        }
        return studentRepo.save(req.toEntity());
    }
}
