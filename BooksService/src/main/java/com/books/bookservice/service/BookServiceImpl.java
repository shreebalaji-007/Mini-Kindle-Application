package com.books.bookservice.service;

import com.books.bookservice.domain.Book;
import com.books.bookservice.exception.BookAlreadyExistsException;
import com.books.bookservice.exception.BookNotFoundException;
import com.books.bookservice.proxy.NotificationProxy;
import com.books.bookservice.repository.BookRepository;
import com.books.bookservice.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final NotificationProxy notificationProxy;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, NotificationProxy notificationProxy) {
        this.bookRepository = bookRepository;
        this.notificationProxy = notificationProxy;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBookByBookId(String bookId) {
        return bookRepository.findByBookId(bookId);
    }

    @Override
    public Book getBookById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(Long.valueOf(id));
        return optionalBook.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book createBook(Book book, String userIdEmail) {
        if (bookRepository.existsById(book.getId(book.getName()))) {
            throw new BookAlreadyExistsException("Book already exists with id: " + book.getId(book.getName()));
        }
        Book createdBook = bookRepository.save(book);
        Notification newNotify = new Notification(userIdEmail, "Book Created", "Your Book ("+ book.getName() +") created successfully.");
        ResponseEntity<?> responseEntity = notificationProxy.sendNotification(newNotify);
        return createdBook;
    }

    @Override
    public Book updateBook(String id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(Long.valueOf(id));
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        Book existingBook = optionalBook.get();
        existingBook.getId(book.getName());
        existingBook.setDescription(book.getDescription());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(String id) {
        if (!bookRepository.existsById(Long.valueOf(id))) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(Long.valueOf(id));
    }
}
