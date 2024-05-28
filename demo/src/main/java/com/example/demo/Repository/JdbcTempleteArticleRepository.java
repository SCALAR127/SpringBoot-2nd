package com.example.demo.Repository;

import com.example.demo.model.Article;
import com.example.demo.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Transactional
public class JdbcTempleteArticleRepository implements ArticleRepositoryInterface {
    private final JdbcTemplate jdbcTemplate;


    public JdbcTempleteArticleRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    @Transactional(readOnly = true)
    public Collection<Article> findBoardId(Long boardId) {
        List<Article> result = jdbcTemplate.query("select * from article where board_id = ?", articleRowMapper(),boardId);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return jdbcTemplate.query("select * from article", articleRowMapper());
    }

    @Override
    public Article save(Article article) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("article").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("author_id", article.getAuthor_id());
        parameters.put("board_id", article.getBoard_id());
        parameters.put("title", article.getTitle());
        parameters.put("content", article.getContent());
        parameters.put("created_date", article.getWriteDate());
        parameters.put("modified_date", article.getModifyDate());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        article.setId(key.longValue());
        return article;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Article> findById(Long id) {
        List<Article> result = jdbcTemplate.query("select * from article where id = ?", articleRowMapper(), Long.valueOf(id));
        return result.stream().findAny();

    }

    @Override
    public Article update(Long id, Article article) {
        String sql = "update article set author_id=?, board_id=?, title=?, content=?, created_date=?, modified_date=? where id = ?";

        jdbcTemplate.update(sql,
                article.getAuthor_id(),
                article.getBoard_id(),
                article.getTitle(),
                article.getContent(),
                article.getWriteDate(),
                article.getModifyDate(),
                id
        );
        article.setId(id);
        return article;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "delete from article where id = ?";
        jdbcTemplate.update(sql, id);

        return false;

    }

    private RowMapper<Article> articleRowMapper() {
        return (rs, rowNum) -> new Article(
                rs.getLong("id"),
                rs.getLong("author_id"),
                rs.getLong("board_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("created_date").toLocalDateTime(),
                rs.getTimestamp("modified_date").toLocalDateTime()
        );
    }
    private RowMapper<Board> boardNameRowMapper() {
        return (rs2, rowNum2) -> new Board(
                rs2.getString("boardName")
        );
    }

}
