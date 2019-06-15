package com.app.projectmanager.spring;

import com.app.projectmanager.spring.dao.ProjectsDAO;
import com.app.projectmanager.spring.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitComponent {

    @Autowired
    ProjectsDAO projectsDAO;

    public void init(){

        Projects projects = new Projects();
        projects.setName("mockup design");

        projects = projectsDAO.save(projects);
        System.out.println();


    }
}
