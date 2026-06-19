package com.ndt.spring.day_40.service;

import java.util.List;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import com.ndt.spring.day_40.repo.RoleRepo;
import com.ndt.spring.day_40.entity.RoleEntity;


@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;


    public List<RoleEntity> getAll() {
        return roleRepo.findAll();
    }
}
