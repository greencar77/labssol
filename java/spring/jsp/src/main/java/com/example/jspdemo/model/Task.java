package com.example.jspdemo.model;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Integer priority;

    public Task() {}

    public Task(Long id, String title, String description, Integer priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
}
