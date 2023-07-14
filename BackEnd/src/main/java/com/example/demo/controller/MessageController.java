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

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    // Get all messages
    @GetMapping("/message")
    public ResponseEntity<?> getAllMessages() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageRepository.findAll()));
        // return messageRepository.findAll();
    }

    // Get message by id
    @GetMapping("/message/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageRepository.findById(id)));
        // return messageRepository.findById(id);
    }

    // Post message
    @PostMapping("/message")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", messageRepository.save(message)));
        // return messageRepository.save(message);
    }

    // Update message
    @PutMapping("/message/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable String id, @RequestBody Message message) {
        Optional<Message> messageExistente = messageRepository.findById(id);
        if (messageExistente.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "Message not found", null));
        }
        /*
         * "id": "64aeebba86e12c106dbf2b35",
         * "message_id": "1",
         * "conversacion_id": "100",
         * "remitente_id": "10",
         * "receptor_id": "20",
         * "mensaje_texto": "Hola, ¿cómo estás?",
         * "fecha_envio": "2023-07-01"
         */
        if (message.getId() != null) {
            messageExistente.get().setId(message.getId());
        }
        if (message.getMessage_id() != null) {
            messageExistente.get().setMessage_id(message.getMessage_id());
        }
        if (message.getConversacion_id() != null) {
            messageExistente.get().setConversacion_id(message.getConversacion_id());
        }
        if (message.getRemitente_id() != null) {
            messageExistente.get().setRemitente_id(message.getRemitente_id());
        }
        if (message.getReceptor_id() != null) {
            messageExistente.get().setReceptor_id(message.getReceptor_id());
        }
        if (message.getMensaje_texto() != null) {
            messageExistente.get().setMensaje_texto(message.getMensaje_texto());
        }
        if (message.getFecha_envio() != null) {
            messageExistente.get().setFecha_envio(message.getFecha_envio());
        }
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", messageRepository.save(messageExistente.get())));
        // return messageRepository.save(message);
    }

    // Delete message
    @DeleteMapping("/message/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        // messageRepository.deleteById(id);
        Optional<Message> messageExistente = messageRepository.findById(id);
        if (messageExistente.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(false, "Message not found", null));
        }
        messageRepository.deleteById(id);
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", false));
    }

}