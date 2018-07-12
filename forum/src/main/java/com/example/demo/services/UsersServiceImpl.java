package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.base.GenericRepository;
import com.example.demo.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersServiceImpl implements UsersService {


    private final GenericRepository<User> usersRepository;
    private final PasswordEncoder passwordEncoder;
    private UserDetails currentUser;

    @Autowired
    public UsersServiceImpl(GenericRepository<User> usersRepository,
                            PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = null;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = usersRepository.getAll()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        return user;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.create(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserDetails getCurrentUser() {
        return this.currentUser;
    }


    public void login(UserDetails user) {
        this.currentUser = user;
    }

}