package com.example.demo.web;

import com.example.demo.entities.Theme;
import com.example.demo.services.base.ThemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ThemeController {

    private final ThemesService themesService;

    @Autowired
    public ThemeController(ThemesService themesService) {
        this.themesService = themesService;
    }

    @RequestMapping("/themes")
    public List<Theme> getAllThemes() {
        List<Theme> themes = themesService.getAllThemes();
        return themes;
    }



}

