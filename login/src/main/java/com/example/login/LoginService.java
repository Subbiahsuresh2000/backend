package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // Create or Update Login
    public Login saveOrUpdateLogin(Login login) {
        return loginRepository.save(login);
    }

    // Get All Logins
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    // Get Login by ID
    public Optional<Login> getLoginById(String loginId) {
        return loginRepository.findById(loginId);
    }

    // Delete Login by ID
    public void deleteLogin(String loginId) {
        loginRepository.deleteById(loginId);
    }

    // Find by Username (Optional)
    public Optional<Login> findByUsername(String username) {
        return loginRepository.findById(username);
    }
}
