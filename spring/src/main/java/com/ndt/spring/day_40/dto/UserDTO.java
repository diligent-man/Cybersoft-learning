package com.ndt.spring.day_40.dto;

import java.time.LocalDateTime;


public record UserDTO(
    String idUser,
    String logInEmail,
    String logInPassword,
    LocalDateTime createDate,
    RoleSummaryDTO role
) {
}
