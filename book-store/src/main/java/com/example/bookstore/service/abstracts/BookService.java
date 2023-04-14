package com.example.bookstore.service.abstracts;

import com.example.bookstore.entity.Book;
import com.example.bookstore.request.BookCreateRequest;
import com.example.bookstore.request.BookUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface BookService {
    Book getOneBookById(Long bookId);
    void deleteOneBookById(Long bookId);

    List<Book> getAllBooks();

    Book createOneRequest(BookCreateRequest request);

    Book updateOneBookById(Long bookId, BookUpdateRequest request);
}
