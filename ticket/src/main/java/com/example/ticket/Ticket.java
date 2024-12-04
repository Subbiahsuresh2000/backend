package com.example.ticket;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "tickets")
public class Ticket {

    @Id
    private String ticketId;
    private String contactName;
    private String accountName;
    private String email;
    private String phone;
    private String subject;
    private String description;
    private String status;
    private String ticketOwner;
    private String productName;
    private Date dueDate;
    private String language;
    private String priority;
    private String channel;
    private String classification;
    private List<String> attachmentUrls;

    // Constructors
    public Ticket() {}

    public Ticket(String ticketId, String contactName, String accountName, String email, String phone, 
                  String subject, String description, String status, String ticketOwner, String productName, 
                  Date dueDate, String language, String priority, String channel, String classification, 
                  List<String> attachmentUrls) {
        this.ticketId = ticketId;
        this.contactName = contactName;
        this.accountName = accountName;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.ticketOwner = ticketOwner;
        this.productName = productName;
        this.dueDate = dueDate;
        this.language = language;
        this.priority = priority;
        this.channel = channel;
        this.classification = classification;
        this.attachmentUrls = attachmentUrls;
    }

    // Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicketOwner() {
        return ticketOwner;
    }

    public void setTicketOwner(String ticketOwner) {
        this.ticketOwner = ticketOwner;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
    }
}
