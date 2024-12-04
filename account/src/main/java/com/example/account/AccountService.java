package com.example.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get an account by ID
    public Optional<Account> getAccountById(String accountId) {
        return accountRepository.findById(accountId);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Update an account
    public Account updateAccount(String accountId, Account account) {
        if (accountRepository.existsById(accountId)) {
            account.setAccountId(accountId);
            return accountRepository.save(account);
        }
        return null;  // Return null if the account is not found
    }

    // Delete an account by ID
    public boolean deleteAccount(String accountId) {
        if (accountRepository.existsById(accountId)) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }
}
