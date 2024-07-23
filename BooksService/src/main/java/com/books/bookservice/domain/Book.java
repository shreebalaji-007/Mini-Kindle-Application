package com.books.bookservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "books")
public class Book {
    @Id

    private String title;
    private String author;
    private Date publicationDate;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(String title, String author, Date publicationDate, Long userId) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    // Getters and Setters

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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }


    public Long getId(Object name) {
        return 0L;
    }

    public Object getName() {
        return null;
    }

    public Object getDescription() {
        return null;
    }

    public void setDescription(Object description) {
    }
}
