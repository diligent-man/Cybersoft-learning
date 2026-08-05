package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q2;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q2.ProductEntity;


@Repository("btJPA2Q2ProductRepo")
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
