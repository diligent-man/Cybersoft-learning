package com.ndt.CRM_project.dto.task;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
public class TaskStatusCountDTO {
    private String name;

    private String color;

    private Long numTask;
}
