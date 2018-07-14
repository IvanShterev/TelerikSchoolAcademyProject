package com.example.demo.entities;

import com.example.demo.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post implements ModelEntity {
    private String postName;
    private String description;
    private int id;

    public Post() {

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

    @Column(name = "postName", length = 25, nullable = false)
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Column(name = "description", length = 25, nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
