package com.ndt.CRM_project.dto.project;

import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.List;
import java.util.HashMap;


@Data
@NoArgsConstructor
public class ProjectTaskStatusStatsDTO {
    private Integer projectId;

    private Integer totalTasks;

    private final Map<String, Integer> taskStatusMap = new HashMap<>();

    private final Map<String, Double> taskStatusRateMap = new HashMap<>();

    private List<UserTaskStatusStatsDTO> userTaskStatusStatsList;
}
