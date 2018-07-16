package com.example.demo.web;

import com.example.demo.entities.User;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "auth/login";
    }

//    @GetMapping("/login")
//    public String login(Model model, @RequestParam Boolean error) {
//        model.addAttribute("error", error);
//        return "auth/login";
//    }


//    @RequestMapping(value="/auth/login", method = RequestMethod.POST)
//    public @ResponseBody String updateUser(@RequestBody User user){
//        usersService.getCurrentUser();
//        return "redirect:/";
//    }
    //
//    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
//    public String CheckLogin(Model model) {
//        return "redirect:/forum/0";
//    }
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

}
