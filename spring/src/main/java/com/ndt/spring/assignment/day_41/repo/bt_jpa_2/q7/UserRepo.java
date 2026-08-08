package com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q7;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q7.UserEntity;


@Repository("btJPA2Q7UserRepo")
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    boolean existsByEmail(String email);
}
