package com.ndt.spring.assignment.day_41.repo.bt_jpa_3.q3;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_3.q3.CategoryEntity;


@Repository("btJPA3Q3CategoryRepo")
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

}
