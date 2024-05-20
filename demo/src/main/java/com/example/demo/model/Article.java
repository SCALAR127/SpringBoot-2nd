package com.example.demo.model;

import java.time.LocalDateTime;

public class Article {
    private int id;
    private int authorId;
    private int boardId;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    public Article(){}

    public Article(int id, int authorId, int boardId, String title, String content, LocalDateTime writeDate, LocalDateTime modifyDate){
        this.id = id;
        this. authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorId(int authorId){
        this.authorId = authorId;
    }
    public int getBoardId(){
        return boardId;
    }
    public void setBoardId(int boardId){
        this.boardId = boardId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public LocalDateTime getWriteDate(){
        return writeDate;
    }
    public void setWriteDate(LocalDateTime writeDate){
        this.writeDate = writeDate;
    }

    public LocalDateTime getModifyDate(){
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate){
        this.modifyDate = modifyDate;
    }
}

