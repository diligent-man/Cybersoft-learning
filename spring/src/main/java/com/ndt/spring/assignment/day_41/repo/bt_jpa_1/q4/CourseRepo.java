package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q4;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q4.CourseEntity;


@Repository("btJPA1Q4CourseRepo")
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {
}
