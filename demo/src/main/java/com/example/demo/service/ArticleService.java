package com.example.demo.service;

import com.example.demo.Repository.ArticleRepository;
import com.example.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Collection<Article> findAll(){
        return articleRepository.findAll();

    }

    public Article findId(int id){
        return articleRepository.find(id);
    }

    public Article save(Article article){
        return articleRepository.save(article);
    }

    public Article updateId(int id, Article article){
        return articleRepository.update(id, article);
    }

    public boolean deleteId(int id){
        return articleRepository.delete(id);
    }



}