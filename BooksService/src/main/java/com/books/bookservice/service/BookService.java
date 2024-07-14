package com.books.bookservice.service;



import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks(Long userId);
    Book getBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id, Long userId);

    List<Book> getBooksByUserId(Long userIdFromToken);
}
