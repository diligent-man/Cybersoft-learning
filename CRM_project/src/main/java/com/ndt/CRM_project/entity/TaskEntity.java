package com.ndt.CRM_project.entity;

import lombok.*;


import com.ndt.CRM_project.model.BaseTimedTaskDetailModel;



@Data
@EqualsAndHashCode(callSuper = true)
public class TaskEntity extends BaseTimedTaskDetailModel {
    private Integer id;

    private String name;

    private Integer userId;

    private String userFullName;

    private Integer projectId;

    private String projectName;

    private Integer statusId;

    private String statusName;

    private String statusColor;
}
