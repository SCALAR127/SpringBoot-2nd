package com.example.demo.Repository;

import com.example.demo.model.Article;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository{
    private final Map<Integer, Article> articleMap = new HashMap<>();
    private int nextId = 1;


    public Collection<Article> findAll(){
        return articleMap.values();
    }

    public Article find(int id){
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

    public boolean delete(int id){
        return articleMap.remove(id) != null;
    }


}