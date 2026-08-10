package com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q1;

import java.util.Optional;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q1.StudentEntity;


@Repository("btJPA3Q1StudentRepo")
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
    boolean existsByEmail(String email);


    Optional<StudentEntity> findByEmail(String email);
}
