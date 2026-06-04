package com.ndt.CRM_project.dto.task;

import java.util.*;

import lombok.*;


@Getter
@ToString
@NoArgsConstructor
public class UserTaskStatusStatsDTO {
    @Setter
    private Integer userId;

    @Setter
    private String fullName;

    @Setter
    private String email;

    private final Map<String, String> taskColorMap = new HashMap<>();

    private final Map<String, List<UserTaskStatusDetailDTO>> taskStatusDetailMap = new HashMap<>();
}
