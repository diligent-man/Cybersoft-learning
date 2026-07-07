package com.ndt.spring.assignment.day_41.service.bt_jpa_1.q1;


import com.ndt.spring.assignment.day_41.entity.bt_jpa_1.q1.UserEntity;
import com.ndt.spring.assignment.day_41.repo.bt_jpa_1.q1.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("btJpa1Q1UserService")
public class UserService {
    @Qualifier("btJpa1Q1UserRepo")
    private final UserRepo userRepo;

    public List<UserEntity> getAll(){
        return userRepo.findAll();
    }
}
