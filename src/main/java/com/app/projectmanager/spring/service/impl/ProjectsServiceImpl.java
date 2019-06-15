package com.app.projectmanager.spring.service.impl;

import com.app.projectmanager.spring.dao.ProjectsDAO;
import com.app.projectmanager.spring.dto.ProjectsDTO;
import com.app.projectmanager.spring.model.Projects;
import com.app.projectmanager.spring.service.ProjectsService;
import com.app.projectmanager.spring.utils.ConvertComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private ProjectsDAO projectsDAO;

    @Autowired
    private ConvertComponent converterComponent;

    @Override
    public List<ProjectsDTO> findAll() {
        return projectsDAO.findAll()
                .stream()
                .map(projects -> converterComponent.convert(projects)) //.map(converterComponent::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectsDTO find(Integer id) {
        return projectsDAO.findById(id)
                .map(converterComponent::convert)
                .orElse(null);
    }

    @Override
    public ProjectsDTO add(ProjectsDTO dto) {
        Projects projects = converterComponent.convert(dto);
        return converterComponent.convert
                (projectsDAO.save(projects));
    }

    @Override
    public ProjectsDTO update(ProjectsDTO dto) {
        Projects projects = projectsDAO.findById(dto.id)
                .orElse(new Projects());
        Projects converted = converterComponent.convert(dto);


        projects.setName(converted.getName());

        return converterComponent.convert(projectsDAO.save(projects));
    }

    @Override
    public ProjectsDTO remove(Integer id) {
        Optional<Projects> projects = projectsDAO.findById(id);
        projects.ifPresent(t -> projectsDAO.delete(t));
        return projects
                .map(converterComponent::convert)
                .orElse(null);
    }
}
