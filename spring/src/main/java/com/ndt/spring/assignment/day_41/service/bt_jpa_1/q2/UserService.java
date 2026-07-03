package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q2;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q2.UserEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q2.UserRepo;


@RequiredArgsConstructor
@Service("btJpa1Q2UserService")
public class UserService {
    @Qualifier("btJpa1Q2UserRepo")
    private final UserRepo userRepo;


    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
