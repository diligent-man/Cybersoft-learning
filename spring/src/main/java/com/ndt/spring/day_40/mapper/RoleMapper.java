package com.ndt.spring.day_40.mapper;

import java.util.List;


import com.ndt.spring.day_40.entity.RoleEntity;
import com.ndt.spring.day_40.entity.UserEntity;

import com.ndt.spring.day_40.dto.RoleDTO;
import com.ndt.spring.day_40.dto.UserDTO;

import com.ndt.spring.day_40.dto.RoleSummaryDTO;
import com.ndt.spring.day_40.dto.UserSummaryDTO;


public class RoleMapper {
    public RoleDTO toDTO(RoleEntity role) {
        List<UserSummaryDTO> users = role.getUsers()
            .stream()
            .map(e -> new UserSummaryDTO(
                e.getId(),
                e.getEmail(),
                e.getPassword(),
                e.getCreateDate()
            ))
            .toList();
        return new RoleDTO(role.getId(), role.getName(), users);
    }



    public UserDTO toUserDTO(UserEntity emp) {
        RoleSummaryDTO role = new RoleSummaryDTO(
            emp.getRole().getId(),
            emp.getRole().getName()
        );
        return new UserDTO(
            emp.getId(),
            emp.getEmail(),
            emp.getPassword(),
            emp.getCreateDate(),
            role
        );
    }
}
