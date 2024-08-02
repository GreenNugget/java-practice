package com.naomi.test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    private String description;

    private String author;
    
    private String cover;

    public Book(){}

    public Book(Integer bookId, String title, String description, String author, String cover){
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.cover = cover;
    }

    public Book(String title, String description, String author, String cover) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.cover = cover;
    }

    public Integer getBookId(){
        return this.bookId;
    }

    public void setBookId(Integer bookId){
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover(){
        return this.cover;
    }

    public void setCover(String cover){
        this.cover = cover;
    }
    
}
