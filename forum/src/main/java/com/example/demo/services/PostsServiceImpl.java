package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.repositories.base.GenericRepository;
import com.example.demo.services.base.PostsService;
import com.example.demo.utils.validator.base.Validator;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements PostsService {

    private final GenericRepository<Post> postsRepository;
    private final Validator<Post> postValidator;

    public PostsServiceImpl(GenericRepository<Post> postsRepository, Validator<Post> postValidator) {
        this.postValidator = postValidator;
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postsRepository.getAll();
    }

    @Override
    public List<Post> getPostByDescription(String descriptionName) {
        List<Post> posts = postsRepository.getAll();

        return posts.stream()
                .filter(theme -> posts.stream()
                        .anyMatch(description ->
                                description.getDescription().equals(descriptionName))
                ).collect(Collectors.toList());
    }

    @Override
    public Post getPostById(int id) {
        return postsRepository.getById(id);
    }

    @Override
    public void createPost(Post post) throws InvalidObjectException {
        if (!postValidator.isValid(post)) {
            throw new InvalidObjectException("Invalid");
        }

        postsRepository.create(post);
    }
}
