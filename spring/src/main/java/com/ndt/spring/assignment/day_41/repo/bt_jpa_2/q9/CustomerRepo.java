package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q9;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q9.CustomerEntity;


@Repository("btJPA2Q9CustomerRepo")
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
