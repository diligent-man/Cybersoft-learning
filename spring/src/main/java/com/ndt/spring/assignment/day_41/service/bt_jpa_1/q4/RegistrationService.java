package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q4;

import java.util.List;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import com.ndt.spring.assignment.day_41.dto.bt_jpa_1.q4.*;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q4.*;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q4.*;

import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q4ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_1.Q4Exception;


@Service("btJPA1Q4RegistrationService")
@RequiredArgsConstructor
public class RegistrationService {
    @Qualifier("btJPA1Q4StudentRepo")
    private final StudentRepo studentRepo;

    @Qualifier("btJPA1Q4CourseRepo")
    private final CourseRepo courseRepo;


    @Transactional(value = "bt-jpa1-q4TransactionManager")
    public RegistrationDTO enrollCourse(Integer studentId, Integer courseId) {
        StudentEntity student = studentRepo
            .findById(studentId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.STUDENT_NOT_FOUND, "Không tìm thấy sinh viên id=" + studentId));

        CourseEntity course = courseRepo
            .findById(courseId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.COURSE_NOT_FOUND, "Không tìm thấy khóa học id=" + courseId));

        if (student.getCourses().contains(course)) {
            throw new Q4Exception(Q4ErrorMsg.COURSE_REGISTERED);
        }

        student.getCourses().add(course);
        return toRegistrationDTO(studentRepo.save(student));
    }


    @Transactional(value = "bt-jpa1-q4TransactionManager")
    public RegistrationDTO unenrollCourse(Integer studentId, Integer courseId) {
        StudentEntity student = studentRepo
            .findById(studentId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.STUDENT_NOT_FOUND, "Không tìm thấy sinh viên id=" + studentId));

        CourseEntity course = courseRepo
            .findById(courseId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.COURSE_NOT_FOUND, "Không tìm thấy khóa học id=" + courseId));

        boolean removed = student.getCourses().removeIf(c -> c.getId().equals(course.getId()));
        if (!removed) {
            throw new Q4Exception(Q4ErrorMsg.COURSE_REGISTERED_NOT_FOUND, "Sinh viên id=" + studentId + " chưa đăng ký khóa học id=" + courseId);
        }
        return toRegistrationDTO(studentRepo.save(student));
    }


    public List<CourseDTO> getCoursesByStudent(Integer studentId) {
        return studentRepo
            .findById(studentId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.STUDENT_NOT_FOUND, "Không tìm thấy sinh viên id=" + studentId))
            .getCourses()
            .stream()
            .map(this::toCourseDTO)
            .toList();
    }


    public List<StudentDTO> getStudentsByCourse(Integer courseId) {
        return courseRepo
            .findById(courseId)
            .orElseThrow(() -> new Q4Exception(Q4ErrorMsg.COURSE_EXISTED, "Không tìm thấy khóa học id=" + courseId))
            .getStudents()
            .stream()
            .map(this::toStudentDTO)
            .toList();
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


    private RegistrationDTO toRegistrationDTO(StudentEntity obj) {
        return RegistrationDTO.builder()
            .name(obj.getName())
            .courses(obj.getCourses().stream().map(this::toCourseDTO).collect(Collectors.toSet()))
            .build();
    }
}

