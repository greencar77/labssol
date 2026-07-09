package com.example.jspdemo.controller;

import com.example.jspdemo.model.Task;
import com.example.jspdemo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("/add-task")
    public String showAddForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }
}
