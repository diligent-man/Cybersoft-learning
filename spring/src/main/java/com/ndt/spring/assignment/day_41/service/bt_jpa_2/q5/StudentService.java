package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.StudentDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5.StudentRepo;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5Exception;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q5.AddStudentReq;


@Service("btJPA2Q5StudentService")
@RequiredArgsConstructor
public class StudentService {
    @Qualifier("btJPA2Q5StudentRepo")
    private final StudentRepo studentRepo;


    public StudentDTO add(AddStudentReq req) {
        if (studentRepo.existsByName(req.getName())) {
            throw new Q5Exception(Q5ErrorMsg.STUDENT_EXISTED);
        }

        return StudentDTO.fromEntity(studentRepo.save(req.toEntity()));
    }
}
