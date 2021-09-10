package com.ktb.model;

import java.util.Date;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private Date publish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish=" + publish +
                '}';
    }

    public Book(Integer id, String name, String author, Date publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }
}
