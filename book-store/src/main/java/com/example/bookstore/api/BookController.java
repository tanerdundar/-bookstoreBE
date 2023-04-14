package com.example.bookstore.api;

import com.example.bookstore.entity.Book;
import com.example.bookstore.request.BookCreateRequest;
import com.example.bookstore.request.BookUpdateRequest;
import com.example.bookstore.service.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public Book createOneBook(@RequestBody BookCreateRequest request) {
        return service.createOneRequest(request);
    }
    @DeleteMapping ("/{bookId}")
    public void deleteOneBook(@PathVariable Long bookId) {
        service.deleteOneBookById(bookId);
    }
    @GetMapping
    public List<Book> getAllBooks() // throws InterruptedException
    {
    //    Thread.sleep(1000);
            return service.getAllBooks();
        }

    @GetMapping("/{bookId}")
    public Book getOneBook(@PathVariable Long bookId) {
        return service.getOneBookById(bookId);
    }
    @PutMapping("/{bookId}")
    public Book updateOneBook(@PathVariable Long bookId, @RequestBody BookUpdateRequest request) {
        return service.updateOneBookById(bookId,request);
    }

}
