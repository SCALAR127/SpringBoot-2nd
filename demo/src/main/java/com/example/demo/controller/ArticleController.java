package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
/*
해야 하는 것
1. Model mapping 하기
2. DTO 생성해서 GET /articles 요청에 title, author, date, content 만 반환하기
Article의 authorId 와 Member의 id 연결,
Article의 boardId와 Board의 id 연결,
Article의 authorId를 통해 Member의 name 찾기,
Article의 boardId를 통해 Board의 boardName 찾기,
Article의 writeDate 찾기
Article의 content 찾기
3. GET /posts 요청에서 게시판 이름, 제목, 이름, 작성일자, 내용 view 하기
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @GetMapping
    public Collection<Article> getAllArticles(){
        return articleService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable int id){
        Article article = articleService.findId(id);
        return article != null ? ResponseEntity.ok(article) :
                ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article saveArticle = articleService.save(article);
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article article){
        Article updateArticle = articleService.update(id, article);
        if (updateArticle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int id){
        boolean delete = articleService.deleteId(id);
        if(!delete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

