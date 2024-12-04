package com.example.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    // Create new Signup
    public Signup saveSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    // Get All Signups
    public List<Signup> getAllSignups() {
        return signupRepository.findAll();
    }

    // Get Signup by ID
    public Optional<Signup> getSignupById(String signupId) {
        return signupRepository.findById(signupId);
    }

    // Get Signup by Username
    public Optional<Signup> getSignupByUsername(String username) {
        return signupRepository.findByUsername(username);
    }

    // Delete Signup by ID
    public void deleteSignup(String signupId) {
        signupRepository.deleteById(signupId);
    }

    // Check if Username Exists
    public boolean usernameExists(String username) {
        return signupRepository.findByUsername(username).isPresent();
    }
}
