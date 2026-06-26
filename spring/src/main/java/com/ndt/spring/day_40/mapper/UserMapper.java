package com.ndt.spring.day_40.mapper;


import com.ndt.spring.day_40.entity.UserEntity;
import com.ndt.spring.day_40.dto.response.UserDTO;
import com.ndt.spring.day_40.dto.response.RoleSummaryDTO;


public class UserMapper {
    public UserDTO toDTO(UserEntity user) {
        RoleSummaryDTO roleDTO = new RoleSummaryDTO(
            user.getRole().getId(),
            user.getRole().getName()
        );

        return new UserDTO(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getCreateDate(),
            roleDTO
        );
    }
}
