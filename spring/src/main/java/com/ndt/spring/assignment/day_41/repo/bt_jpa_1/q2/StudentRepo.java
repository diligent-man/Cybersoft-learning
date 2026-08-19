package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q2;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.StudentEntity;


@Repository("btJPA1Q2StudentRepo")
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    List<StudentEntity> findByNameContainingIgnoreCase(String name);
}
