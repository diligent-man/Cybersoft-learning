package com.ndt.spring.assignment.day_41.service.bt_jpa_2.q7;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


import com.ndt.spring.assignment.day_41.repo.bt_jpa_2.q7.UserRepo;
import com.ndt.spring.assignment.day_41.entity.bt_jpa_2.q7.UserEntity;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q7ErrorMsg;
import com.ndt.spring.assignment.day_41.exception.bt_jpa_2.Q7Exception;
import com.ndt.spring.assignment.day_41.payload.req.bt_jpa_2.q7.AddUserReq;


@Service("btJPA2Q7UserService")
@RequiredArgsConstructor
public class UserService {
    @Qualifier("btJPA2Q7UserRepo")
    private final UserRepo userRepo;


    public UserEntity add(AddUserReq req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new Q7Exception(Q7ErrorMsg.USER_EXISTED);
        }

        return userRepo.save(req.toEntity());
    }
}
