package com.example.demo.entities;

import com.example.demo.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "themes")
public class Theme implements ModelEntity {
    private String themeName;
    private String description;
    private int id;

    public Theme(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "themeName", length = 25 , nullable = false)
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Column(name = "description", length = 25 , nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
