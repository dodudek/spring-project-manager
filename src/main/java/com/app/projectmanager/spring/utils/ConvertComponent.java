package com.app.projectmanager.spring.utils;

import com.app.projectmanager.spring.dto.ProjectsDTO;
import com.app.projectmanager.spring.model.Projects;
import org.springframework.stereotype.Component;

@Component
public class ConvertComponent {

    public Projects convert (ProjectsDTO projectsDTO){
        Projects projects = new Projects();
        projects.setId(projectsDTO.id);
        projects.setName(projectsDTO.name);

        return projects;
    }

    public ProjectsDTO convert (Projects projects){
        ProjectsDTO dto = new ProjectsDTO();
        dto.id = projects.getId();
        dto.name = projects.getName();
        return dto;
    }
}
