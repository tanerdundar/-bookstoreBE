package com.example.bookstore.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name="book")
public class Book {

    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column (name="title")
    private String title;

    @Column (name="author")
    private String author;

    @Column (name="publisher")
    private String publisher;

    @Column (name="published_year")
    private int publishedYear;

    @Column (name="description")
    private String description;

}
