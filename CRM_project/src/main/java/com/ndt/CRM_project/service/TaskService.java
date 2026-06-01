package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.entity.ProjectEntity;
import com.ndt.CRM_project.entity.TaskEntity;
import com.ndt.CRM_project.repo.ProjectRepo;
import com.ndt.CRM_project.repo.TaskRepo;


public class TaskService {
    private final TaskRepo taskRepo = new TaskRepo();


    public List<TaskEntity> getAll() {
        return taskRepo.findAll();
    }


    // public boolean addTask(ProjectEntity obj) {
    //     return projectRepo.save(obj) > 0;
    // }
}
