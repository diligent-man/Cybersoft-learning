package com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3.ProductEntity;


@Repository("btJPA3Q3ProductRepo")
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    boolean existsByName(String name);


    Page<ProductEntity> findAll(Specification<ProductEntity> specs, Pageable pageable);
}
