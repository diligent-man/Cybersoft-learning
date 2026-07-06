package com.ndt.CRM_project.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class BaseTimedTaskDetailModel extends BaseTaskTimeModel {
    @Setter
    @JsonProperty("task_id")
    protected Integer taskId;

    @Setter
    @JsonProperty("task_name")
    protected String taskName;
}
