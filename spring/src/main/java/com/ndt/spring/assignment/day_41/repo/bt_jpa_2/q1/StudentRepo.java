package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q1;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q1.StudentEntity;


@Repository("btJPA2Q1StudentRepo")
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    boolean existsByEmail(String email);
}
