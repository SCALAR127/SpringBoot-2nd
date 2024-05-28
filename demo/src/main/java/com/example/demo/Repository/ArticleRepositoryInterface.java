package com.example.demo.Repository;

import com.example.demo.model.Article;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ArticleRepositoryInterface {
    Collection<Article> findBoardId(Long boardId);

    List<Article> findAll();
    Article save(Article article);

    Optional<Article> findById(Long id);

    Article update(Long id, Article article);

    boolean delete(Long id);
}
