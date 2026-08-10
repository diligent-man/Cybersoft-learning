package com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q2;

import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q2.ProductEntity;


@Repository("btJPA3Q2ProductRepo")
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    boolean existsByName(String name);


    Optional<ProductEntity> findByName(String name);


    // equivalent to Page<ProductEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<ProductEntity> findAll(Specification<ProductEntity> specs, Pageable pageable);
}
