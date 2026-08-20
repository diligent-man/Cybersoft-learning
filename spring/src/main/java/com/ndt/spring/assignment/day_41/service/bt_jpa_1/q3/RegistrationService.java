package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q3;

import java.util.List;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q3.*;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q3.*;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.*;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_1.q3.*;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q3ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q3Exception;


@Service("btJPA1Q3RegistrationService")
@RequiredArgsConstructor
public class RegistrationService {
    @Qualifier("btJPA1Q3StudentRepo")
    private final StudentRepo studentRepo;

    @Qualifier("btJPA1Q3CourseRepo")
    private final CourseRepo courseRepo;

    @Qualifier("btJPA1Q3RegistrationRepo")
    private final RegistrationRepo registrationRepo;


    @Transactional(value = "bt-jpa1-q3TransactionManager")
    public List<RegistrationDTO> registerCourses(Integer studentId, RegisterCourseReq req) {
        StudentEntity student = studentRepo
            .findById(studentId)
            .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.STUDENT_NOT_FOUND, "Không tìm thấy sinh viên id=" + studentId));

        List<RegistrationEntity> newRegistrations = req
            .getCourseIds()
            .stream()
            .distinct()
            .filter(courseId -> registrationRepo
                .findByStudent_IdAndCourse_Id(studentId, courseId).isEmpty()
            )
            .map(courseId -> {
                CourseEntity course = courseRepo
                    .findById(courseId)
                    .orElseThrow(() -> new Q3Exception(Q3ErrorMsg.COURSE_NOT_FOUND, "Không tìm thấy khóa học id=" + courseId));

                RegistrationEntity reg = new RegistrationEntity();
                reg.setStudent(student);
                reg.setCourse(course);
                return reg;
            })
            .collect(Collectors.toList());

        List<RegistrationEntity> saved = registrationRepo.saveAll(newRegistrations);
        return saved
            .stream()
            .map(this::toRegistrationDTO)
            .collect(Collectors.toList());
    }


    public List<CourseDTO> getCoursesByStudent(Integer studentId) {
        if (!studentRepo.existsById(studentId)) {
            throw new Q3Exception(Q3ErrorMsg.STUDENT_NOT_FOUND, "Không tìm thấy sinh viên id=" + studentId);
        }
        return registrationRepo
            .findByStudent_Id(studentId)
            .stream()
            .map(RegistrationEntity::getCourse)
            .map(this::toCourseDTO)
            .collect(Collectors.toList());
    }


    public List<StudentDTO> getStudentsByCourse(Integer courseId) {
        if (!courseRepo.existsById(courseId)) {
            throw new Q3Exception(Q3ErrorMsg.COURSE_NOT_FOUND, "Không tìm thấy khóa học id=" + courseId);
        }
        return registrationRepo
            .findByCourse_Id(courseId)
            .stream()
            .map(RegistrationEntity::getStudent)
            .map(this::toStudentDTO)
            .collect(Collectors.toList());
    }


    // ---------- mapper helpers ----------
    private CourseDTO toCourseDTO(CourseEntity obj) {
        return CourseDTO.builder()
            .title(obj.getTitle())
            .duration(obj.getDuration())
            .build();
    }


    private StudentDTO toStudentDTO(StudentEntity obj) {
        return StudentDTO.builder()
            .name(obj.getName())
            .email(obj.getEmail())
            .build();
    }


    private RegistrationDTO toRegistrationDTO(RegistrationEntity obj) {
        return RegistrationDTO.builder()
            .studentId(obj.getStudent().getId())
            .courseId(obj.getCourse().getId())
            .registrationDate(obj.getRegistrationDate())
            .build();
    }
}
