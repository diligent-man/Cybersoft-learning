package com.ndt.CRM_project.dto.task;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserTaskStatusStatsDTO {
    private Integer userId;

    private String fullName;

    private String email;

    private Integer totalTasks;

    private final Map<String, Integer> taskStatusMap = new HashMap<>();

    private final Map<String, Double> taskStatusRateMap = new HashMap<>();

    private final Map<String, String> taskColorMap = new HashMap<>();

    private final Map<String, List<UserTaskStatusDetailDTO>> taskStatusDetailMap = new HashMap<>();
}
