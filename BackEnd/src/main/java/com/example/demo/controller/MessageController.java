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
import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // Get all messages
    @GetMapping("/message")
    public ResponseEntity<?> getAllMessages() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageService.listMessage()));
    }

    // Get message by id
    @GetMapping("/message/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageService.getMessageById(id)));
    }

    // Post message
    @PostMapping("/message")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageService.saveMessage(message)));
    }

    // Update message
    @PutMapping("/message/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable String id, @RequestBody Message message) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", messageService.updateMessage(id, message)));
    }

    // Delete message
    @DeleteMapping("/message/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageService.deleteMessage(id)));
    }

}