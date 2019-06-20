package com.app.projectmanager.spring.controller;

import com.app.projectmanager.spring.dto.ProjectsDTO;
import com.app.projectmanager.spring.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @GetMapping
    public List<ProjectsDTO> getAll(){
        return projectsService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectsDTO get(@PathVariable int id){
        return projectsService.find(id);
    }

    @DeleteMapping("/{id}")
    public ProjectsDTO delete(@PathVariable int id){
        return projectsService.remove(id);
    }

    @PostMapping
    public ProjectsDTO add(@RequestBody @NotNull @Valid ProjectsDTO dto ){
        return projectsService.add(dto);
    }

    @PutMapping
    public ProjectsDTO update(@RequestBody @NotNull @Valid ProjectsDTO dto ){
        return projectsService.update(dto);
    }
}
