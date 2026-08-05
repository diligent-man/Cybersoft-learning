package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q8;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q8.OrderEntity;


@Repository("btJPA2Q8OrderRepo")
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
