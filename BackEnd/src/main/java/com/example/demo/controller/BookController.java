package com.example.demo.controller;

import java.util.Optional;

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

    // Get book by id
    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", bookRepository.findById(id)));
        // return bookRepository.findById(id);
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
        Optional<Book> bookExistente = bookRepository.findById(id);
        if (bookExistente.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "Book not found", null));
        }
        /*
         * "id": "64ac3f5e655b292f71fb62dd",
         * "book_id": "12345",
         * "user_id": "98765",
         * "ownership_id": "abcde",
         * "date_start": "2023-06-01",
         * "date_finish": "2023-06-15"
         */
        if (book.getBook_id() != null) {
            bookExistente.get().setBook_id(book.getBook_id());
        }
        if (book.getUser_id() != null) {
            bookExistente.get().setUser_id(book.getUser_id());
        }
        if (book.getOwnership_id() != null) {
            bookExistente.get().setOwnership_id(book.getOwnership_id());
        }
        if (book.getDate_start() != null) {
            bookExistente.get().setDate_start(book.getDate_start());
        }
        if (book.getDate_finish() != null) {
            bookExistente.get().setDate_finish(book.getDate_finish());
        }
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", bookRepository.save(bookExistente.get())));

        // return bookRepository.save(book);
    }

    // Delete book
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        Optional<Book> bookExistente = bookRepository.findById(id);
        if (bookExistente.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "Book not found", null));
        }
        bookRepository.delete(bookExistente.get());
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", null));
    }

}
