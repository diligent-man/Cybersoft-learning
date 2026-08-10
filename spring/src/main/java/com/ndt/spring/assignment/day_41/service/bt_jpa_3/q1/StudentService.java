package com.ndt.spring.assignment.day_41.service.bt_jpa_3.q1;

import java.util.List;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q1.StudentEntity;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q1.AddStudentReq;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_3.q1.UpdateStudentReq;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_3.q1.StudentDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q1.StudentRepo;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q1ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_3.Q1Exception;


@RequiredArgsConstructor
@Service("btJPA3Q1StudentService")
public class StudentService {
    @Qualifier("btJPA3Q1StudentRepo")
    private final StudentRepo studentRepo;


    public List<StudentDTO> getAll() {
        return studentRepo
            .findAll()
            .parallelStream()
            .map(StudentDTO::fromEntity)
            .toList();
    }


    public StudentDTO getById(Integer id) {
        return StudentDTO.fromEntity(
            studentRepo
                .findById(id)
                .orElseThrow(() -> new Q1Exception(Q1ErrorMsg.NOT_FOUND))
        );
    }


    public StudentDTO save(AddStudentReq req) {
        if (studentRepo.existsByEmail(req.getEmail())) {
            throw new Q1Exception(Q1ErrorMsg.EXISTED, "Email '" + req.getEmail() + "' is already registered");
        }
        return StudentDTO.fromEntity(studentRepo.save(req.toEntity()));
    }


    public StudentDTO update(Integer id, UpdateStudentReq req) {
        StudentEntity student = studentRepo.findById(id)
            .orElseThrow(() -> new Q1Exception(Q1ErrorMsg.NOT_FOUND, "Email '" + req.getEmail() + "' is already registered"));

        student.setName(req.getName());
        student.setMajor(req.getMajor());
        student.setMajor(req.getMajor());
        return StudentDTO.fromEntity(studentRepo.save(student));
    }


    public StudentDTO delete(Integer id) {
        StudentEntity student = studentRepo
            .findById(id)
            .orElseThrow(() -> new Q1Exception(Q1ErrorMsg.NOT_FOUND, "Id '" + id + " doesn't exist"));
        studentRepo.delete(student);
        return StudentDTO.fromEntity(student);
    }
}
