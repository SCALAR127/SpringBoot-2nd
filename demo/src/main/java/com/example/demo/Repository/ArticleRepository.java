/*
ackage com.example.demo.Repository;

import com.example.demo.model.Article;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ArticleRepository implements ArticleRepositoryInterface{
    private final Map<Integer, Article> articleMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public Collection<Article> findBoardId(Long boardId) {
        return articleMap.values();
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Article find(Long id) {
        return articleMap.get(id);
    }
    @Override
    public Article save(Article article) {
        article.setId(nextId++);
        article.setWriteDate(LocalDateTime.now());
        article.setModifyDate(LocalDateTime.now());
        articleMap.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Article update(Long id, Article article) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Article update(Long id, Article article) {
        article.setId(id);
        article.setModifyDate(LocalDateTime.now());
        articleMap.put(id, article);
        return article;
    }

    public boolean delete(Long id) {
        return articleMap.remove(id) != null;
    }


}

 */