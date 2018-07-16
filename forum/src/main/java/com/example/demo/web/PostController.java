package com.example.demo.web;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.services.base.PostsService;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.security.Principal;
import java.util.List;

@Controller
public class PostController {

    private final PostsService postsService;
    private final UsersService userService;

    @Autowired
    public PostController(PostsService postsService, UsersService usersService) {
        this.userService = usersService;
        this.postsService = postsService;
    }

    @RequestMapping("/posts")
    public List<Post> getAllPosts() {
        List<Post> posts = postsService.getAllPosts();
        return posts;
    }

    @GetMapping("/posts/{id}")
    public String details(@PathVariable String id, Model model) {
        Post post = postsService.getPostById(Integer.parseInt(id));
        model.addAttribute("id", id);
        model.addAttribute("post", post);
        return "/posts/details";
    }

    //    @GetMapping("/posts/create")
//    public String create(Model model){
//        Post post = new Post();
//        model.addAttribute("post", post);
//        return "/posts/create";
//    }
    @GetMapping("/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String add(
            @ModelAttribute Post post,
            Principal princpal
    ) {
        try {
            User user = userService.getUserByUsername(princpal.getName());
            post.setUser(user);
            postsService.createPost(post);
            return "redirect:/";
        } catch (InvalidObjectException e) {
            return "index";
        }
    }

    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable String id) {
        int num = Integer.parseInt(id);
        postsService.deletePost(num);
        return "redirect:/";
    }
}

