package com.books.bookservice.repository;

import com.books.bookservice.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUserId(Long userId);

    List<Book> findByBookId(String bookId);
}