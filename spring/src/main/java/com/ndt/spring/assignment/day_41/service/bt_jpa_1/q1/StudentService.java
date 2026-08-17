package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1;

import java.util.List;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q1.*;


import com.ndt.spring.exception.GenericErrorMsg;
import com.ndt.spring.exception.GenericException;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1Exception;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q1.StudentRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.StudentEntity;


@RequiredArgsConstructor
@Service("btJPA1Q1StudentService")
public class StudentService {
    @Qualifier("btJPA1Q1StudentRepo")
    private final StudentRepo studentRepo;


    public List<StudentEntity> getAll() {
        return studentRepo.findAll();
    }


    public StudentEntity getById(int id) {
        return studentRepo.findById(id).orElseThrow(() -> new Q1Exception(Q1ErrorMsg.STUDENT_NOT_FOUND));
    }


    public StudentEntity save(AddStudentReq req) {
        if (studentRepo.existsByName(req.getName())) {
            throw new GenericException(GenericErrorMsg.CONFLICT, req.getName() + "' is already existed");
        }
        return studentRepo.save(req.toEntity());
    }


    public StudentEntity update(Integer id, UpdateStudentReq req) {
        StudentEntity student = getById(id);

        student.setName(req.getName());
        student.setEmail(req.getEmail());
        student.setAge(req.getAge());

        return studentRepo.save(student);
    }


    public StudentEntity delete(Integer id) {
        StudentEntity student = getById(id);
        studentRepo.delete(student);
        return student;
    }
}
