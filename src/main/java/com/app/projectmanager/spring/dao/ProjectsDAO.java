package com.app.projectmanager.spring.dao;

import com.app.projectmanager.spring.model.Projects;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsDAO extends CrudRepository<Projects, Integer> {

    List<Projects> findAll();
}
