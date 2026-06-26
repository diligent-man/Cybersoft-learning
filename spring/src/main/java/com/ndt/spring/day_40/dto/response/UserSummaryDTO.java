package com.ndt.spring.day_40.dto.response;

import java.time.LocalDateTime;


public record UserSummaryDTO(
    String id,
    String email,
    String password,
    LocalDateTime createDate
) {
}
