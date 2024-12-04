package com.example.signup;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface SignupRepository extends MongoRepository<Signup, String> {
    Optional<Signup> findByUsername(String username);
}
