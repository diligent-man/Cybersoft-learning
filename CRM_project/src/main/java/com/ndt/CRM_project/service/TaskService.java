package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.repo.TaskRepo;

import com.ndt.CRM_project.entity.TaskEntity;

import com.ndt.CRM_project.dto.task.TaskStatusCountDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;


public class TaskService {
    private final TaskRepo taskRepo = new TaskRepo();


    public List<TaskEntity> getAll() {
        return taskRepo.findAll();
    }


    public TaskEntity getTask(int id) {
        return taskRepo.findById(id).orElse(null);
    }


    public boolean save(TaskEntity obj) {
        return taskRepo.save(obj) > 0;
    }


    public boolean update(TaskEntity obj) {
        return taskRepo.update(obj) > 0;
    }


    public boolean delete(int id) {
        return taskRepo.deleteById(id) > 0;
    }


    public List<TaskStatusCountDTO> getTaskByUserStatus() {
        return taskRepo.findTaskByUserStatus();
    }


    public UserTaskStatusStatsDTO getTaskByUserStatus(int userId) {
        return taskRepo.findTaskByUserStatus(userId).orElse(null);
    }
}
