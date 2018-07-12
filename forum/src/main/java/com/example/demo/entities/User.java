package com.example.demo.entities;

import com.example.demo.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements ModelEntity {
    private int id;
    private String username;
    private String password;


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 30, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
