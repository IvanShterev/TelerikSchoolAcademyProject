package com.example.demo.web;

import com.example.demo.entities.User;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService)
    {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute User user, Principal principal
    ) {
        usersService.create(user);
        return "redirect:/login";
    }
//    } {
//        usersService.create(user);
//        return "auth/register";
//    }

//    @GetMapping("/users/{username}")
//    public String profile(@PathVariable String username, Model model, Principal principal) {
//        User profile = usersService.getUserByUsername(username);
//        String title = profile.getUsername();
//
//        if (principal != null) {
//            User loggedInUser = usersService.getUserByUsername(principal.getName());
//            if (loggedInUser.getId() == profile.getId()) {
//                title = "My profile";
//            }
//        }
//
//        model.addAttribute("title", title);
//        model.addAttribute("profile", profile);
//
//        return "users/profile";
//    }
//
    @GetMapping("/login")
    String login() {
        return "auth/login";
    }
//
//    @PostMapping("/auth/login")
//    public String login(@ModelAttribute User user) {
//        UserDetails current = usersService.loadUserByUsername(user.getUsername());
//        usersService.login(current);
//        return "redirect:/";
//    }

}
