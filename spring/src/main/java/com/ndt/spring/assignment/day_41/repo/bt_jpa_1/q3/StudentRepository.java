package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q3;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q3.StudentEntity;
import org.springframework.stereotype.Repository;


@Repository("btJPA1Q3StudentRepo")
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}