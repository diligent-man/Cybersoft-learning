package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q3;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.RegistrationEntity;


@Repository("btJPA1Q3RegistrationRepo")
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {

    // Lấy danh sách khóa học mà 1 sinh viên đã đăng ký
    List<RegistrationEntity> findByStudent_Id(Integer studentId);


    // Lấy danh sách sinh viên đã đăng ký 1 khóa học
    List<RegistrationEntity> findByCourse_Id(Integer courseId);


    // Kiểm tra tránh đăng ký trùng
    Optional<RegistrationEntity> findByStudent_IdAndCourse_Id(Integer studentId, Integer courseId);
}