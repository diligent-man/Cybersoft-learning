package com.ndt.CRM_project.dto.model;

import lombok.*;


import com.fasterxml.jackson.annotation.JsonProperty;


@Setter
@Getter
@NoArgsConstructor
public class BaseTaskDetailModel {
    @Setter
    @JsonProperty("task_id")
    protected Integer taskId;

    @Setter
    @JsonProperty("task_name")
    protected String taskName;
}
