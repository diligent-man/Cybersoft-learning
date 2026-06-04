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

    @Setter
    private Integer totalTasks;

    private final Map<String, Integer> taskStatusMap = new HashMap<>();

    private final Map<String, Double> taskStatusRateMap = new HashMap<>();

    private final Map<String, String> taskColorMap = new HashMap<>();

    private final Map<String, List<UserTaskStatusDetailDTO>> taskStatusDetailMap = new HashMap<>();
}
