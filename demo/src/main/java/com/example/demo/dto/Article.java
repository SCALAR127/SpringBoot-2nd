package com.example.demo.dto;

public class Article {
    private Long id;
    private String name;
    private  int age;
    private String description;

    public Article() {

    }

    public Article(Long id, String name, int age, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
