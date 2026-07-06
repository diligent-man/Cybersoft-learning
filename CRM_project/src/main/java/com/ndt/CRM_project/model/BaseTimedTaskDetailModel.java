package com.ndt.CRM_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTimedTaskDetailModel extends BaseTaskTimeModel {
    @Setter
    @JsonProperty("task_id")
    protected Integer taskId;

    @Setter
    @JsonProperty("task_name")
    protected String taskName;
}
