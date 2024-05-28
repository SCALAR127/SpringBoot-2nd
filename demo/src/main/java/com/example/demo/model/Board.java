package com.example.demo.model;

public class Board {
    private int id;
    private String boardName;

    public Board() {
    }

    public Board(int id, String boardName) {
        this.id = id;
        this.boardName = boardName;
    }

    public Board(String boardName) {
        this.boardName = boardName;
    }

    public int getBoardId() {
        return id;
    }

    public void setBoardId(int id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName() {
        this.boardName = boardName;
    }
}
