package com.example.demo.web;

import com.example.demo.entities.Theme;
import com.example.demo.services.base.ThemesService;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ThemesService themesService;
    private final UsersService usersService;


    @Autowired
    public HomeController(ThemesService themesService, UsersService usersService) {
        this.themesService = themesService;
        this.usersService = usersService;
    }
    @GetMapping ("/")
    public String index(Model model) {
        List<Theme> themes = themesService.getAllThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("user",usersService.getCurrentUser());
        return "index";
    }


}


