package com.example.demo.services.base;

import com.example.demo.entities.Post;

import java.io.InvalidObjectException;
import java.util.List;

public interface PostsService {
    List<Post> getAllPosts();

    List<Post> getPostByDescription(String description);

    Post getPostById(int id);

    void createPost(Post post) throws InvalidObjectException;

    void deletePost(int id);

//    void addCommentToPost(int id, String content);
}
