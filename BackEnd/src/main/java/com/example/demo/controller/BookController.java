package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Get all books
    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookRepository.findAll()));
        // return bookRepository.findAll();
    }

    // Post book
    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookRepository.save(book)));
        // return bookRepository.save(book);
    }

    // Update book
    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setBook_id(id);
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookRepository.save(book)));

        // return bookRepository.save(book);
    }

    // Delete book
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);
    }

}
