package com.example.demo.dto;

import java.time.LocalDateTime;

public class ArticleResponseDTO {
    private Long id;
    private Long author_id;
    private Long board_id;

    private String title;
    private String content;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Long getId() {
        return id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public Long getBoard_id() {
        return board_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public LocalDateTime getModified_date() {
        return modified_date;
    }

    public ArticleResponseDTO(Long id, Long author_id, Long board_id, String title, String content, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.author_id = author_id;
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }
}
