package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    // Get book by id
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Post book
    public Book saveBook(Book book) {
        // System.out.println("Producto Agregado: " + book.toString());
        return bookRepository.save(book);
    }

    // Update book
    public Book updateBook(String id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getBook_id() != null)
            bookToUpdate.setBook_id(book.getBook_id());
        if (book.getUser_id() != null)
            bookToUpdate.setUser_id(book.getUser_id());
        if (book.getOwnership_id() != null)
            bookToUpdate.setOwnership_id(book.getOwnership_id());
        if (book.getDate_start() != null)
            bookToUpdate.setDate_start(book.getDate_start());
        if (book.getDate_finish() != null)
            bookToUpdate.setDate_finish(book.getDate_finish());
        return bookRepository.save(bookToUpdate);
    }

    // Delete book
    public Boolean deleteBook(String id) {
        bookRepository.deleteById(id);
        return true;
    }
}
