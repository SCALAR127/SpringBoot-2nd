package com.example.demo.service;

import com.example.demo.Repository.ArticleRepositoryInterface;
//import com.example.demo.Repository.JdbcArticleRepository;
import com.example.demo.dto.ArticleCreateDTO;
import com.example.demo.dto.ArticleResponseDTO;
import com.example.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

public class ArticleService {
    private final ArticleRepositoryInterface articleRepositoryInterface;
    @Autowired
    public ArticleService(ArticleRepositoryInterface articleRepositoryInterface) {
        this.articleRepositoryInterface = articleRepositoryInterface;
    }

    public Collection<Article> findBoardId(Long boardId) {
        return articleRepositoryInterface.findBoardId(boardId);

    }

    public Optional<Article> findId(Long id) {
        return articleRepositoryInterface.findById(id);
    }

    public ArticleResponseDTO save(ArticleCreateDTO request) {
        Article article = new Article(
                request.getAuthor_id(),
                request.getBoard_id(),
                request.getTitle(),
                request.getContent()
        );


        Article save = articleRepositoryInterface.save(article);

        ArticleResponseDTO result = new ArticleResponseDTO(
                article.getId(),
                article.getAuthor_id(),
                article.getBoard_id(),
                article.getTitle(),
                article.getContent(),
                article.getWriteDate(),
                article.getModifyDate()
        );

        return result;
    }

    public ArticleResponseDTO updateId(Long id, ArticleCreateDTO request) {
        Article article = new Article(
                request.getAuthor_id(),
                request.getBoard_id(),
                request.getTitle(),
                request.getContent()
        );

        articleRepositoryInterface.update(id, article);

        ArticleResponseDTO result = new ArticleResponseDTO(
                article.getId(),
                article.getAuthor_id(),
                article.getBoard_id(),
                article.getTitle(),
                article.getContent(),
                article.getWriteDate(),
                article.getModifyDate()
        );

        return result;
    }

    public boolean deleteId(Long id) {
        return articleRepositoryInterface.delete(id);
    }


}