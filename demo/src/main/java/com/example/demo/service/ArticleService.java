package com.example.demo.service;

import com.example.demo.model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ArticleService{
    private final Map<Integer, Article> articleMap = new HashMap<>();
    private int nextId = 1;

    public Collection<Article> findAll(){
        return articleMap.values();
    }

    public Article findId(int id){
        return articleMap.get(id);
    }

    public Article save(Article article){
        article.setId(nextId++);
        article.setWriteDate(LocalDateTime.now());
        article.setModifyDate(LocalDateTime.now());
        articleMap.put(article.getId(), article);
        return article;
    }

    public Article update(int id, Article article){
        if(!articleMap.containsKey(id)){
            return null;
        }
        article.setId(id);
        article.setModifyDate(LocalDateTime.now());
        articleMap.put(id, article);
        return article;
    }

    public boolean deleteId(int id){
        return articleMap.remove(id) != null;
    }

}