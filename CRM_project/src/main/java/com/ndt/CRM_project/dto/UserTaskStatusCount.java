package com.ndt.CRM_project.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.*;


@Getter
@ToString
@NoArgsConstructor
public class UserTaskStatusCount {
    @Setter
    private Integer userId;

    @Setter
    private String fullName;

    @Setter
    private String email;

    @Setter
    private Map<String, UserStatusTaskDetail> statusTaskMap;

    @Setter
    private String color;

    @Setter
    private Integer numTask;

    private List<Integer> taskIds;


    public void setTaskIds(String taskIds) {
        setTaskIds(taskIds, ",");
    }


    public void setTaskIds(String taskIds, String delimiter) {
        this.taskIds = Arrays.stream(taskIds.split(delimiter))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }


    public void setTaskIds(List<Integer> taskIds) {
        this.taskIds = taskIds;
    }
}
