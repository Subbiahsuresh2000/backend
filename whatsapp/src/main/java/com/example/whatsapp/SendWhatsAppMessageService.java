package com.example.whatsapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SendWhatsAppMessageService {

    @Autowired
    private SendWhatsAppMessageRepository repository;

    // Save a new WhatsApp message
    public SendWhatsAppMessage saveMessage(SendWhatsAppMessage message) {
        // Here, you can integrate with WhatsApp API to send the message
        return repository.save(message);
    }

    // Get all messages
    public List<SendWhatsAppMessage> getAllMessages() {
        return repository.findAll();
    }

    // Get message by ID
    public Optional<SendWhatsAppMessage> getMessageById(String id) {
        return repository.findById(id);
    }

    // Get message by phone number
    public Optional<SendWhatsAppMessage> getMessageByPhoneNo(String phoneNo) {
        return repository.findByPhoneNo(phoneNo);
    }

    // Delete message by ID
    public void deleteMessage(String id) {
        repository.deleteById(id);
    }

    // Update message by ID
    public SendWhatsAppMessage updateMessage(String id, SendWhatsAppMessage message) {
        Optional<SendWhatsAppMessage> existingMessage = repository.findById(id);
        if (existingMessage.isPresent()) {
            message.setMessageId(id); // Make sure to set the correct ID for update
            return repository.save(message);
        }
        return null;
    }
}
