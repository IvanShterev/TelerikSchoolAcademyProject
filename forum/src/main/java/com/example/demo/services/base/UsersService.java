package com.example.demo.services.base;

import com.example.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    User getUserByUsername(String username);

    void create(User user);

    UserDetails getCurrentUser();

    void login(UserDetails current);

}
