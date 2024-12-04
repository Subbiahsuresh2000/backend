package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Create or Update Login
    @PostMapping
    public ResponseEntity<Login> createOrUpdateLogin(@RequestBody Login login) {
        Login savedLogin = loginService.saveOrUpdateLogin(login);
        return new ResponseEntity<>(savedLogin, HttpStatus.CREATED);
    }

    // Get All Logins
    @GetMapping
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginService.getAllLogins();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    // Get Login by ID
    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable("id") String id) {
        Optional<Login> login = loginService.getLoginById(id);
        return login.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get Login by Username (Optional)
    @GetMapping("/username/{username}")
    public ResponseEntity<Login> getLoginByUsername(@PathVariable("username") String username) {
        Optional<Login> login = loginService.findByUsername(username);
        return login.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Login by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable("id") String id) {
        loginService.deleteLogin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update Login by ID
    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable("id") String id, @RequestBody Login login) {
        Optional<Login> existingLogin = loginService.getLoginById(id);
        if (existingLogin.isPresent()) {
            login.setLoginId(id);
            Login updatedLogin = loginService.saveOrUpdateLogin(login);
            return new ResponseEntity<>(updatedLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
