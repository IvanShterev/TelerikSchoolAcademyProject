package com.example.demo.config;

import com.example.demo.entities.Theme;
import com.example.demo.entities.User;
import com.example.demo.repositories.HibernateRepository;
import com.example.demo.repositories.base.GenericRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @Autowired
    GenericRepository<Theme> provideProductsGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<Theme> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(Theme.class);

        return repo;
    }


    @Bean
    @Autowired
    GenericRepository<User> provideUsersGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<User> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(User.class);

        return repo;
    }

    @Bean
    SessionFactory provideSessionFactory() {

        return HibernateUtils.getSessionFactory();
    }

//    @Bean
//    Validator<Theme> provideProductValidator() {
//        return new ProductValidator();
//    }
}