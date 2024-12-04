package com.example.whatsapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/whatsappmessages")
public class SendWhatsAppMessageController {

    @Autowired
    private SendWhatsAppMessageService messageService;

    // Create a new WhatsApp message (POST method)
    @PostMapping
    public ResponseEntity<SendWhatsAppMessage> createMessage(@RequestBody SendWhatsAppMessage message) {
        SendWhatsAppMessage createdMessage = messageService.saveMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    // Get all WhatsApp messages (GET method)
    @GetMapping
    public ResponseEntity<List<SendWhatsAppMessage>> getAllMessages() {
        List<SendWhatsAppMessage> messages = messageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    // Get WhatsApp message by ID (GET method)
    @GetMapping("/{id}")
    public ResponseEntity<SendWhatsAppMessage> getMessageById(@PathVariable("id") String id) {
        Optional<SendWhatsAppMessage> message = messageService.getMessageById(id);
        return message.map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get WhatsApp message by Phone Number (GET method)
    @GetMapping("/phone/{phoneNo}")
    public ResponseEntity<SendWhatsAppMessage> getMessageByPhoneNo(@PathVariable("phoneNo") String phoneNo) {
        Optional<SendWhatsAppMessage> message = messageService.getMessageByPhoneNo(phoneNo);
        return message.map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete WhatsApp message by ID (DELETE method)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") String id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update WhatsApp message by ID (PUT method)
    @PutMapping("/{id}")
    public ResponseEntity<SendWhatsAppMessage> updateMessage(@PathVariable("id") String id, @RequestBody SendWhatsAppMessage message) {
        SendWhatsAppMessage updatedMessage = messageService.updateMessage(id, message);
        return updatedMessage != null ? new ResponseEntity<>(updatedMessage, HttpStatus.OK)
                                      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
