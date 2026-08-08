package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.ProductEntity;



@Repository("btJPA2Q4ProductRepo")
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(Integer id);
}
