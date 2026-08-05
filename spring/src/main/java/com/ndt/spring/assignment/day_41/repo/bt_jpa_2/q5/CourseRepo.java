package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q5;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q5.CourseEntity;


@Repository("btJPA2Q5CourseRepo")
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}
