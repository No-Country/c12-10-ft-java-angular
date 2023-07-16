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
        if (message.getMessage_id() != null)
            messageToUpdate.setMessage_id(message.getMessage_id());
        if (message.getConversacion_id() != null)
            messageToUpdate.setConversacion_id(message.getConversacion_id());
        if (message.getRemitente_id() != null)
            messageToUpdate.setRemitente_id(message.getRemitente_id());
        if (message.getReceptor_id() != null)
            messageToUpdate.setReceptor_id(message.getReceptor_id());
        if (message.getMensaje_texto() != null)
            messageToUpdate.setMensaje_texto(message.getMensaje_texto());
        if (message.getFecha_envio() != null)
            messageToUpdate.setFecha_envio(message.getFecha_envio());
        return messageRepository.save(messageToUpdate);
    }

    // Delete message
    public Boolean deleteMessage(String id) {
        messageRepository.deleteById(id);
        return true;
    }

}
