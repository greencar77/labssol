package com.example.jspdemo.service;

import com.example.jspdemo.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public TaskService() {
        saveTask(new Task(null, "Learn Spring Boot", "Understand the basics of Spring Boot 3.5", 1));
        saveTask(new Task(null, "Learn JSP", "Understand how JSP works with Spring", 2));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void saveTask(Task task) {
        if (task.getId() == null) {
            task.setId(counter.incrementAndGet());
        }
        tasks.add(task);
    }
}
