package com.example.BookJPA.Entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    private String author;
    private Long publishedYear;
    private Double price;

    public Book(){}

    public Book(String title, String author, Long publishedYear, Double price) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Long publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
