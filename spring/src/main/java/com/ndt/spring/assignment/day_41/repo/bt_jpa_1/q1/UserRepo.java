package com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q1;

import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("btJpa1Q1UserRepo")
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
