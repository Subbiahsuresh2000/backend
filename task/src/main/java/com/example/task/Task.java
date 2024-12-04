package com.example.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String taskId;
    private String subject;
    private String ticket;
    private String dueDate;
    private String taskOwner;
    private String contactName;
    private String status;
    private String priority;
    private String setReminder;
    private String description;

    // Constructors
    public Task() {}

    public Task(String taskId, String subject, String ticket, String dueDate, String taskOwner, 
                String contactName, String status, String priority, String setReminder, String description) {
        this.taskId = taskId;
        this.subject = subject;
        this.ticket = ticket;
        this.dueDate = dueDate;
        this.taskOwner = taskOwner;
        this.contactName = contactName;
        this.status = status;
        this.priority = priority;
        this.setReminder = setReminder;
        this.description = description;
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(String taskOwner) {
        this.taskOwner = taskOwner;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSetReminder() {
        return setReminder;
    }

    public void setSetReminder(String setReminder) {
        this.setReminder = setReminder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
