package com.example.demo.utils.validator;

import com.example.demo.entities.Post;
import com.example.demo.utils.validator.base.Validator;
import org.springframework.stereotype.Service;

@Service
public class PostValidator implements Validator<Post> {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 20;

    @Override
    public boolean isValid(Post post) {
        return post != null &&
                isNameValid(post.getPostName())
                ;
    }

    private boolean isNameValid(String name) {
        return name != null &&
                name.length() >= MIN_NAME_LENGTH &&
                name.length() <= MAX_NAME_LENGTH;
    }

}
