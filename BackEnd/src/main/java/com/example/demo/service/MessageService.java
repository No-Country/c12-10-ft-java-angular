package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Get all messages
    public List<Message> listMessage() {
        return messageRepository.findAll();
    }

    // Get message by id
    public Message getMessageById(String id) {
        return messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    // Post message
    public Message saveMessage(Message message) {
        // System.out.println("Message Agregado: " + message.toString());
        return messageRepository.save(message);
    }

    public Message updateMessage(String id, Message message) {
        Message messageToUpdate = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        if (message.getMessageId() != null)
            messageToUpdate.setMessageId(message.getMessageId());
        if (message.getConversacionId() != null)
            messageToUpdate.setConversacionId(message.getConversacionId());
        if (message.getRemitenteId() != null)
            messageToUpdate.setRemitenteId(message.getRemitenteId());
        if (message.getReceptorId() != null)
            messageToUpdate.setReceptorId(message.getReceptorId());
        if (message.getMensajeTexto() != null)
            messageToUpdate.setMensajeTexto(message.getMensajeTexto());
        if (message.getFechaEnvio() != null)
            messageToUpdate.setFechaEnvio(message.getFechaEnvio());
        return messageRepository.save(messageToUpdate);
    }

    // Delete message
    public Boolean deleteMessage(String id) {
        messageRepository.deleteById(id);
        return true;
    }

}
