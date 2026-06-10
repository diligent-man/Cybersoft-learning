package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.repo.ProjectRepo;
import com.ndt.CRM_project.entity.ProjectEntity;


public class ProjectService {
    private final ProjectRepo projectRepo = new ProjectRepo();


    public List<ProjectEntity> getAll() {
        return projectRepo.findAll();
    }


    public ProjectEntity getProject(int id) {
        return projectRepo.findById(id).orElse(null);
    }


    public boolean save(ProjectEntity obj) {
        return projectRepo.save(obj) > 0;
    }


    public boolean update(ProjectEntity obj) {
        return projectRepo.update(obj) > 0;
    }


    public boolean delete(int id) {
        return projectRepo.delete(id) > 0;
    }

}
