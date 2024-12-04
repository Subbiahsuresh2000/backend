package com.example.account;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {

    @Id
    private String accountId;
    private String accountName;
    private String email;
    private String phone;
    private String website;
    private String country;
    private String accountOwner;

    // Constructors
    public Account() {}

    public Account(String accountId, String accountName, String email, String phone, 
                   String website, String country, String accountOwner) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.country = country;
        this.accountOwner = accountOwner;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
}

