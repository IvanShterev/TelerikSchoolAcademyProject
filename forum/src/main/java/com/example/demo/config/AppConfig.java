package com.example.demo.config;

import com.example.demo.entities.Post;
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
    GenericRepository<Post> provideProductsGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<Post> repo = new HibernateRepository<>(sessionFactory);
        repo.setEntityClass(Post.class);

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
//    Validator<Post> provideProductValidator() {
//        return new ProductValidator();
//    }
}