package com.example.demo.repositories.base;

import com.example.demo.entities.base.ModelEntity;

import java.util.List;

public interface GenericRepository<T extends ModelEntity> {
    List<T> getAll();

    T getById(int id);

    T create(T entity);

    T delete(T entity);
}
