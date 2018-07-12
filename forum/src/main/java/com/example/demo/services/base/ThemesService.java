package com.example.demo.services.base;

import com.example.demo.entities.Theme;

import java.util.List;

public interface ThemesService {
    List<Theme> getAllThemes();
    List<Theme> getThemeByDescription(String description);
    Theme getThemeById(int id);
}
