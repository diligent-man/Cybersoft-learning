package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q5;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q5.StudentEntity;


@Repository("btJPA1Q5StudentRepo")
public interface StudentRepo extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {

}
