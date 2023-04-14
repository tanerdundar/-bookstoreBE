package com.example.bookstore.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BookUpdateRequest {

    private String title;

    private String author;

    private String publisher;
    private int publishedYear;
    private String description;

}
