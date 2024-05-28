package com.example.demo.controller;

import com.example.demo.dto.ArticleCreateDTO;
import com.example.demo.dto.ArticleResponseDTO;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Collection<Article> getAllArticles(@RequestParam Long boardId) {
        return articleService.findBoardId(boardId);
    }


    @GetMapping("/articles/{id}")
    public ResponseEntity<Optional<Article>> getArticle(@PathVariable Long id) {
        Optional<Article> article = articleService.findId(id);
        return ResponseEntity.ok(article);

    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleResponseDTO> createArticle(
            @RequestBody ArticleCreateDTO article
    ) {
        ArticleResponseDTO saveArticle = articleService.save(article);
        return ResponseEntity.ok(saveArticle);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponseDTO> updateArticle(
            @PathVariable Long id,
            @RequestBody ArticleCreateDTO article
    ) {
        ArticleResponseDTO updateArticle = articleService.updateId(id, article);
        return ResponseEntity.ok(updateArticle);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        boolean delete = articleService.deleteId(id);
        if (!delete) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

