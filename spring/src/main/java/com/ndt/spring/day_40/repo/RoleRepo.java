package com.ndt.spring.day_40.repo;

import com.ndt.spring.day_40.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("demo40RoleRepo")
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

}
