package com.ndt.CRM_project.dto.user;

import java.util.*;


import lombok.*;


import com.ndt.CRM_project.dto.model.BaseTaskStatusModel;


@Setter
@Getter
@NoArgsConstructor
public class UserTaskStatusStatsDTO extends BaseTaskStatusModel {
    private Integer userId;

    private String fullName;

    private String email;

    private final Map<String, List<UserTaskDetailDTO>> taskStatusDetailMap = new HashMap<>();
}
