package com.example.demo.services;

import com.example.demo.entities.Theme;
import com.example.demo.repositories.base.GenericRepository;
import com.example.demo.services.base.ThemesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemesServiceImpl implements ThemesService {

    private final GenericRepository<Theme> themesRepository;

    public ThemesServiceImpl(GenericRepository<Theme> themesRepository) {

        this.themesRepository = themesRepository;
    }

    @Override
    public List<Theme> getAllThemes() {
        return themesRepository.getAll();
    }

    @Override
    public List<Theme> getThemeByDescription(String descriptionName) {
        List<Theme> themes = themesRepository.getAll();

        return themes.stream()
                .filter(theme -> themes.stream()
                        .anyMatch(description ->
                                description.getDescription().equals(descriptionName))
                ).collect(Collectors.toList());
    }

    @Override
    public Theme getThemeById(int id) {
        return themesRepository.getById(id);
    }
}
