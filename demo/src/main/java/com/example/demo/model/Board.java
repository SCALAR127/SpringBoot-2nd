package com.example.demo.model;

public class Board {
    private int id;
    private String boardName;

    public Board(){}

    public Board(int id, String boardName){
        this.id = id;
        this.boardName = boardName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getBoardName(){
        return boardName;
    }

    public void setBoardName(){
        this.boardName = boardName;
    }
}
