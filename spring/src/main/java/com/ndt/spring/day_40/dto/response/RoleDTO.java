package com.ndt.spring.day_40.dto.response;


import java.util.List;


public record RoleDTO(
    Integer id,
    String name,
    List<UserSummaryDTO> users
) {
}
