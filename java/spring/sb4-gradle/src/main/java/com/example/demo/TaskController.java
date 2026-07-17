package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listTasks(Model model) {
        List<Task> tasks = repository.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        if (description != null && !description.trim().isEmpty()) {
            repository.save(new Task(description));
        }
        return "redirect:/";
    }
}
