package com.ndt.CRM_project.model;

import lombok.*;


import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class BaseTaskDetailModel {
    @Setter
    @JsonProperty("task_id")
    protected Integer taskId;

    @Setter
    @JsonProperty("task_name")
    protected String taskName;
}
