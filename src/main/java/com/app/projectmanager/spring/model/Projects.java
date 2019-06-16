package com.app.projectmanager.spring.model;

import javax.persistence.*;

@Entity
@Table
public class Projects {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable=false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
