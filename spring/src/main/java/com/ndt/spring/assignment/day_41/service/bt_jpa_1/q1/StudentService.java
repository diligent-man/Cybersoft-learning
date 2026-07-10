package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1;

import java.util.List;


import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q1Exception;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentListResp;
import com.ndt.spring.assignment.day_41.payload.resp.bt_jpa_1.Q1StudentResp;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.StudentEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q1.StudentRepo;


@RequiredArgsConstructor
@Service("btJpa1Q1StudentService")
public class StudentService {
    @Qualifier("btJpa1Q1StudentRepo")
    private final StudentRepo userRepo;


    public Q1StudentListResp getAll() {
        List<StudentEntity> students = userRepo.findAll();

        return Q1StudentListResp.builder()
            .code(200)
            .status("success")
            .data(students)
            .build();
    }

    public Q1StudentResp getById(int id){
        StudentEntity student = userRepo.findById(id).orElseThrow(() -> new Q1Exception(Q1ErrorMsg.STUDENT_NOT_FOUND));
        return Q1StudentResp.builder()
            .code(200)
            .status("success")
            .data(student)
            .build();
    }
}
