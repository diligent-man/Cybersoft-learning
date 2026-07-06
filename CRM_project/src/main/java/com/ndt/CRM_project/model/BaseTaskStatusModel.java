package com.ndt.CRM_project.model;

import java.util.*;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class BaseTaskStatusModel {
    protected final Map<String, Integer> taskStatusTotalMap = new HashMap<>();

    protected final Map<String, Double> taskStatusRateMap = new HashMap<>();

    protected final Map<String, String> taskColorMap = new HashMap<>();
}
