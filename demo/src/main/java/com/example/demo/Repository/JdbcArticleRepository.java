/*
package com.example.demo.Repository;

import com.example.demo.model.Article;
import com.example.demo.model.Board;
import com.example.demo.model.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;
@Transactional
public class JdbcArticleRepository implements ArticleRepositoryInterface {

    private final DataSource dataSource;

    public JdbcArticleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Collection<Article> findBoardId(int boardId) {
        return null;
    }

    @Override
    public Article find(int id) {
        return null;
    }

    @Override
    public Article save(Article article) {

        String sql = "INSERT INTO article (author_id, board_id, title, content, created_date, modified_date) VALUES ( ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO member(id, name, email, password) VALUES(?, ?, ?, ?)";
        String sql3 = "INSERT INTO board(id, name) VALUES(?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, article.getAuthor_id());
            pstmt.setString(2, "name");
            pstmt.setString(3, "a");
            pstmt.setString(4, "1234");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, article.getBoard_id());
            pstmt.setLong(2, article.getBoard_id());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, article.getAuthor_id());
            pstmt.setLong(2, article.getBoard_id());
            pstmt.setString(3, article.getTitle());
            pstmt.setString(4, article.getContent());
            pstmt.setObject(5, article.getWriteDate());
            pstmt.setObject(6, article.getModifyDate());




            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                article.setId((int) rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return article;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Article> findById(Long id) {
        String sql = "select * from article where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Article article = new Article();
                article.setId((int) rs.getLong("id"));
                article.setTitle(rs.getString("title"));
                return Optional.of(article);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Article update(int id, Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        String sql = "select * from article";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Article> members = new ArrayList<>();
            while(rs.next()) {
                Article member = new Article();
                member.setId((int) rs.getLong("id"));
                member.setTitle(rs.getString("title"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }

    public boolean delete(int id) {
        return true;
    }
}

 */

