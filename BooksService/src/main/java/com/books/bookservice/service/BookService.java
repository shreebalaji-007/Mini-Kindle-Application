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

    List<com.books.bookservice.domain.Book> getAllBooks();

    List<com.books.bookservice.domain.Book> getBookByBookId(String bookId);

    com.books.bookservice.domain.Book getBookById(String id);

    com.books.bookservice.domain.Book createBook(com.books.bookservice.domain.Book book, String userIdEmail);

    com.books.bookservice.domain.Book updateBook(String id, com.books.bookservice.domain.Book book);

    void deleteBook(String id);
}
