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
import com.example.demo.service.BookService;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping("/book")
    public ResponseEntity<?> listBook() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookService.listBook()));
    }
    // Get book by id

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookService.getBookById(id)));
    }
    // Post book

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookService.saveBook(book)));
    }
    // Update book

    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookService.updateBook(id, book)));
    }

    // Delete book

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookService.deleteBook(id)));
    }

}
