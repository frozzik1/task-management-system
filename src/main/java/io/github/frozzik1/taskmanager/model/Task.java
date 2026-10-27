package io.github.frozzik1.taskmanager.model;

import java.time.LocalDateTime;

public abstract class Task {
    private static int idCounter = 0;
    private final int id;
    private String title;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;

    public Task(String title, String description) {
        this.id = ++idCounter;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public abstract String getTaskType();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Title: '%s' | Status: %s | Created: %s",
                getTaskType(), id, title, status, createdAt);
    }
}