package com.example.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
    // You can define custom queries here, for example:
    // List<Task> findByStatus(String status);
}
