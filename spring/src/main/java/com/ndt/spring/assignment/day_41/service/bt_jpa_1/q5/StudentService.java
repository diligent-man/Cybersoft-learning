package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q5;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q5.*;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q5.*;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5.*;

import com.ndt.spring.assignment.day_41.search_spec.bt_jpa_1.q5.StudentSpecs;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q5.StudentSearchReq;


@Service("btJPA1Q5StudentService")
@RequiredArgsConstructor
public class StudentService {
    @Qualifier("btJPA1Q5StudentRepo")
    private final StudentRepo studentRepo;


    public Page<StudentDTO> search(StudentSearchReq req, Pageable pageable) {
        Specification<StudentEntity> spec = StudentSpecs.build(
            req.getName(),
            req.getAgeFrom(),
            req.getAgeTo(),
            req.getEmailDomain()
        );
        return studentRepo
            .findAll(spec, pageable)
            .map(this::toStudentDto);
    }


    public StudentDTO toStudentDto(StudentEntity student) {
        return StudentDTO.fromEntity(student);
    }
}
