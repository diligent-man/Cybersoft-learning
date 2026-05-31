package com.ndt.CRM_project.service;

import java.util.List;


import com.ndt.CRM_project.repo.ProjectRepo;
import com.ndt.CRM_project.entity.ProjectEntity;


public class ProjectService {
    private final ProjectRepo groupworkRepo = new ProjectRepo();


    public List<ProjectEntity> getAll() {
        return groupworkRepo.findAll();
    }


    public boolean addGroupwork(ProjectEntity obj) {
        return groupworkRepo.save(obj) > 0;
    }
}
