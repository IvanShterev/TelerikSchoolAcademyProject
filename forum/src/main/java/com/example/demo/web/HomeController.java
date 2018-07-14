package com.example.demo.web;

import com.example.demo.entities.Post;
import com.example.demo.services.base.PostsService;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PostsService postsService;
    private final UsersService usersService;


    @Autowired
    public HomeController(PostsService postsService, UsersService usersService) {
        this.postsService = postsService;
        this.usersService = usersService;
    }
    @GetMapping ("/")
    public String index(Model model) {
        List<Post> posts = postsService.getAllPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("user",usersService.getCurrentUser());
        return "index";
    }


}


