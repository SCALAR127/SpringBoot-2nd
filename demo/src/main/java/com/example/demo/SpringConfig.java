package com.example.demo;

import com.example.demo.Repository.ArticleRepositoryInterface;
//import com.example.demo.Repository.JdbcArticleRepository;
import com.example.demo.Repository.JdbcTempleteArticleRepository;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    ArticleService articleService(){
        return new ArticleService(articleRepositoryInterface());
    }

    @Bean
    ArticleRepositoryInterface articleRepositoryInterface(){
        return new JdbcTempleteArticleRepository(dataSource);
    }
}
