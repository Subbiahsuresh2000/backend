package com.example.login;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, String> {
    // Custom query methods can be added here, for example:
    // Optional<Login> findByUsername(String username);
}
