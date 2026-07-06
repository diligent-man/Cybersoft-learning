package com.ndt.CRM_project.dto.project;

import java.util.Map;
import java.util.HashMap;


import lombok.*;


import com.ndt.CRM_project.dto.model.BaseTaskStatusModel;


@Getter
@Setter
@NoArgsConstructor
public class UserTaskStatusStatsDTO extends BaseTaskStatusModel {
    private Integer userId;

    private String fullName;

    private final Map<String, UserTaskDetailDTO> taskStatusDetailMap = new HashMap<>();
}
