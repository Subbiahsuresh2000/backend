package com.example.whatsapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "whatsapp_messages")
public class SendWhatsAppMessage {

    @Id
    private String messageId;
    private String department;
    private String contactName;
    private String phoneNo;
    private String whatsappChannel; // e.g., "WhatsApp Business", "WhatsApp API"
    private String messageContent;
    
    // Constructors
    public SendWhatsAppMessage() {}

    public SendWhatsAppMessage(String messageId, String department, String contactName, String phoneNo, 
                                String whatsappChannel, String messageContent) {
        this.messageId = messageId;
        this.department = department;
        this.contactName = contactName;
        this.phoneNo = phoneNo;
        this.whatsappChannel = whatsappChannel;
        this.messageContent = messageContent;
    }

    // Getters and Setters
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getWhatsappChannel() {
        return whatsappChannel;
    }

    public void setWhatsappChannel(String whatsappChannel) {
        this.whatsappChannel = whatsappChannel;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
