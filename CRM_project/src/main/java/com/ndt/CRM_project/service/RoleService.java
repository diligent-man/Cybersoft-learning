package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.repo.RoleRepo;
import com.ndt.CRM_project.entity.RoleEntity;



public class RoleService {
    private final RoleRepo roleRepo = new RoleRepo();


    public List<RoleEntity> getAll() {
        return roleRepo.findAll();
    }


    public RoleEntity getRoleById(int id) {
        return roleRepo.findById(id).orElse(null);
    }

    public boolean addRole(RoleEntity obj) {
        return roleRepo.save(obj) > 0;
    }

    public boolean update(RoleEntity obj) {
        return roleRepo.update(obj) > 0;
    }
}
