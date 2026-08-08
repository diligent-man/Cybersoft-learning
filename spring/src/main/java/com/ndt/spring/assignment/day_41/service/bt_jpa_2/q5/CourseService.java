package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.CourseDTO;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5.CourseRepo;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5Exception;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q5.AddCourseReq;


@Service("btJPA2Q5CourseService")
@RequiredArgsConstructor
public class CourseService {
    @Qualifier("btJPA2Q5CourseRepo")
    private final CourseRepo courseRepo;


    public CourseDTO addCourse(AddCourseReq req) {
        if (courseRepo.existsByTitle((req.getTitle()))) {
            throw new Q5Exception(Q5ErrorMsg.COURSE_EXISTED);
        }

        return CourseDTO.fromEntity(courseRepo.save(req.toEntity()));
    }
}
