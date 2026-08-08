package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q5;

import java.util.List;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_2.q5.RegistrationDTO;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.CourseEntity;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.StudentEntity;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.RegistrationEntity;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q5Exception;

import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5.CourseRepo;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5.StudentRepo;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5.RegistrationRepo;


@Service("btJPA2Q5RegistrationService")
@RequiredArgsConstructor
public class RegistrationService {
    @Qualifier("btJPA2Q5StudentRepo")
    private final StudentRepo studentRepo;

    @Qualifier("btJPA2Q5CourseRepo")
    private final CourseRepo courseRepo;

    @Qualifier("btJPA2Q5RegistrationRepo")
    private final RegistrationRepo registrationRepo;


    public List<CourseEntity> getCoursesByStudent(Integer studentId) {
        if (!studentRepo.existsById(studentId)) {
            throw new Q5Exception(Q5ErrorMsg.STUDENT_NOT_FOUND);
        }

        return registrationRepo.findAllByStudent_Id(studentId)
            .stream()
            .map(RegistrationEntity::getCourse)
            .toList();
    }


    public RegistrationDTO registerCourse(Integer studentId, Integer courseId) {
        StudentEntity student = studentRepo
            .findById(studentId)
            .orElseThrow(() -> new Q5Exception(Q5ErrorMsg.STUDENT_NOT_FOUND));

        CourseEntity course = courseRepo
            .findById(courseId)
            .orElseThrow(() -> new Q5Exception(Q5ErrorMsg.COURSE_NOT_FOUND));

        if (registrationRepo.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new Q5Exception(Q5ErrorMsg.COURSE_EXISTED);
        }

        RegistrationEntity registration = new RegistrationEntity();
        registration.setStudent(student);
        registration.setCourse(course);
        return RegistrationDTO.fromEntity(registrationRepo.save(registration));
    }
}
