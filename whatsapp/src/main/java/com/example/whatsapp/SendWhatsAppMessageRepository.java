package com.example.whatsapp;



import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface SendWhatsAppMessageRepository extends MongoRepository<SendWhatsAppMessage, String> {
    Optional<SendWhatsAppMessage> findByPhoneNo(String phoneNo);
}
