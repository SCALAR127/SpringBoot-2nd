package com.example.demo.dto;

public class ArticleCreateDTO {
    private Long board_id;
    private Long author_id;
    private String title;
    private String content;

    public Long getBoard_id() {
        return board_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
