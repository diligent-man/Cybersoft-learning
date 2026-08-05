package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q6;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q6.EmployeeEntity;


@Repository("btJPA2Q6EmployeeRepo")
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
