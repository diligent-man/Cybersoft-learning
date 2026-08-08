package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q4;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q4.CategoryEntity;


@Repository("btJPA2Q4CategoryRepo")
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
    boolean existsByName(String name);
}
