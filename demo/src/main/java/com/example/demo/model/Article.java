package com.example.demo.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long author_id;
    private Long board_id;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    public Article(Long id, Long author_id, Long board_id, String title, String content, LocalDateTime writeDate, LocalDateTime modifyDate) {
        this.id = id;
        this.author_id = author_id;
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }

    public Article(Long author_id, Long board_id, String title, String content) {
        this.id = null;
        this.author_id = author_id;
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.writeDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}

