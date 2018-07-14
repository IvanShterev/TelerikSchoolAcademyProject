package com.example.demo.utils.validator.base;

public interface Validator<T> {
    boolean isValid(T object);
}
