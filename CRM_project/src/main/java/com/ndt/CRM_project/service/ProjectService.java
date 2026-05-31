package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.repo.ProjectRepo;
import com.ndt.CRM_project.entity.ProjectEntity;


public class ProjectService {
    private final ProjectRepo projectRepo = new ProjectRepo();


    public List<ProjectEntity> getAll() {
        return projectRepo.findAll();
    }


    public boolean addProject(ProjectEntity obj) {
        return projectRepo.save(obj) > 0;
    }
}
