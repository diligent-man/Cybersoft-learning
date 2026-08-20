package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q3;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.RegistrationEntity;


@Repository("btJPA1Q3RegistrationRepo")
public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Integer> {
    List<RegistrationEntity> findByStudent_Id(Integer studentId);


    List<RegistrationEntity> findByCourse_Id(Integer courseId);


    Optional<RegistrationEntity> findByStudent_IdAndCourse_Id(Integer studentId, Integer courseId);
}
