package com.example.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/signups")
public class SignupController {

    @Autowired
    private SignupService signupService;

    // Create a new Signup (POST method)
    @PostMapping
    public ResponseEntity<Signup> createSignup(@RequestBody Signup signup) {
        // Check if the username already exists
        if (signupService.usernameExists(signup.getUsername())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Username already exists
        }
        Signup createdSignup = signupService.saveSignup(signup);
        return new ResponseEntity<>(createdSignup, HttpStatus.CREATED);
    }

    // Get all Signups (GET method)
    @GetMapping
    public ResponseEntity<List<Signup>> getAllSignups() {
        List<Signup> signups = signupService.getAllSignups();
        return new ResponseEntity<>(signups, HttpStatus.OK);
    }

    // Get Signup by ID (GET method)
    @GetMapping("/{id}")
    public ResponseEntity<Signup> getSignupById(@PathVariable("id") String id) {
        Optional<Signup> signup = signupService.getSignupById(id);
        return signup.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get Signup by Username (GET method)
    @GetMapping("/username/{username}")
    public ResponseEntity<Signup> getSignupByUsername(@PathVariable("username") String username) {
        Optional<Signup> signup = signupService.getSignupByUsername(username);
        return signup.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Signup by ID (DELETE method)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignup(@PathVariable("id") String id) {
        signupService.deleteSignup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update Signup by ID (PUT method)
    @PutMapping("/{id}")
    public ResponseEntity<Signup> updateSignup(@PathVariable("id") String id, @RequestBody Signup signup) {
        Optional<Signup> existingSignup = signupService.getSignupById(id);
        if (existingSignup.isPresent()) {
            signup.setSignupId(id);
            Signup updatedSignup = signupService.saveSignup(signup);
            return new ResponseEntity<>(updatedSignup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
