package com.app.projectmanager.spring.service;

import com.app.projectmanager.spring.dto.ProjectsDTO;

import java.util.List;

public interface ProjectsService {

    List<ProjectsDTO> findAll();
    ProjectsDTO find(Integer id);
    ProjectsDTO add(ProjectsDTO dto);
    ProjectsDTO update(ProjectsDTO dto);
    ProjectsDTO remove(Integer id);
}
