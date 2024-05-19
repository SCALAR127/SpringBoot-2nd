package com.example.demo.controller;

import com.example.demo.dto.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
    private Map<Long, Article> articles = new HashMap<>();
    private long currentId = 0;


    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id){
        Article article = articles.get(id);
        return article != null ? ResponseEntity.ok(article) :
                ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        article.setId(++currentId);
        articles.put(article.getId(), article);
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article){
        if (articles.containsKey(id)){
            article.setId(id);
            articles.put(id, article);
            return ResponseEntity.ok(article);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        if (articles.remove(id) != null){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

