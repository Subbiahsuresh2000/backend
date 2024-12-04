package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create or Update Task
    public Task saveOrUpdateTask(Task task) {
        return taskRepository.save(task);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get Task by ID
    public Optional<Task> getTaskById(String taskId) {
        return taskRepository.findById(taskId);
    }

    // Delete Task by ID
    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }
}
