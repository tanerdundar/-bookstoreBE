package com.example.bookstore.service.concrete;

import com.example.bookstore.dao.BookRepository;
import com.example.bookstore.entity.Book;
import com.example.bookstore.request.BookCreateRequest;
import com.example.bookstore.request.BookUpdateRequest;
import com.example.bookstore.service.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookManager implements BookService {

    private final BookRepository repository;

    @Override
    public Book getOneBookById(Long bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteOneBookById(Long bookId) {
        repository.deleteById(bookId);
    }
    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book createOneRequest(BookCreateRequest request) {
        Book bookToSave = new Book();

        bookToSave.setTitle(request.getTitle());
        bookToSave.setAuthor(request.getAuthor());
        bookToSave.setPublisher(request.getPublisher());
        bookToSave.setPublishedYear(request.getPublishedYear());
        bookToSave.setDescription(request.getDescription());

        return repository.save(bookToSave);
    }

    @Override
    public Book updateOneBookById(Long bookId, BookUpdateRequest request) {
       Optional<Book> book = repository.findById(bookId);
        if(book.isPresent()) {
            Book bookToUpdate = book.get();
            bookToUpdate.setTitle(request.getTitle());
            bookToUpdate.setAuthor(request.getAuthor());
            bookToUpdate.setPublisher(request.getPublisher());
            bookToUpdate.setDescription(request.getDescription());
            bookToUpdate.setPublishedYear(request.getPublishedYear());
            return repository.save(bookToUpdate);
        } else
            return null;
    }
}
