package com.example.demo.model;

public class Member {
    private int id;
    private String name;
    private String emailAddress;
    private String password;


    public Member() {
    }

    public Member(int id, String name, String emailAddress, String password) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

