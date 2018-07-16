package com.example.demo.entities;

import com.example.demo.entities.base.ModelEntity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post implements ModelEntity {
    private String postName;
    private String description;
    private int id;
    private User user;

    public Post() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @ManyToMany
//    @JoinColumn(na)
//    public Message getMessage() {
//        return message;
//    }
//
//    public void setMessage(Message message) {
//        this.message = message;
//    }

//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", postName='" + postName + '\'' +
//                ", description='" + description + '\'' +
//                ", user ='" + user.getUsername() + '\'' +
//                '}';
//    }
}
