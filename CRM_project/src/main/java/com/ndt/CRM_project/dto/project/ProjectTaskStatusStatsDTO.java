package com.ndt.CRM_project.dto.project;

import java.util.*;


import lombok.*;


import com.ndt.CRM_project.dto.model.BaseTaskStatusModel;


@Setter
@Getter
@NoArgsConstructor
public class ProjectTaskStatusStatsDTO extends BaseTaskStatusModel {
    private Integer projectId;

    private final List<UserTaskStatusStatsDTO> userTaskStatusStatsList = new ArrayList<>();
}
