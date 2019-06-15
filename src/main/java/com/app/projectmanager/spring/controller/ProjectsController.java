package com.app.projectmanager.spring.controller;

import com.app.projectmanager.spring.dto.ProjectsDTO;
import com.app.projectmanager.spring.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/projects")
    public List<ProjectsDTO> getAll(){
        return projectsService.findAll();
    }

    @GetMapping("/projects/{id}")
    public ProjectsDTO get(@PathVariable int id){
        return projectsService.find(id);
    }

    @DeleteMapping("/projects/{id}")
    public ProjectsDTO delete(@PathVariable int id){
        return projectsService.remove(id);
    }

    @Validated
    @PostMapping("/projects")
    public ProjectsDTO add(@RequestBody @NotNull ProjectsDTO dto ){
        return projectsService.add(dto);
    }
}
