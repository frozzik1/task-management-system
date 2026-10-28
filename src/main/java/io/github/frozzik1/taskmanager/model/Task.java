package io.github.frozzik1.taskmanager.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    public static final int MAX_TITLE_LENGTH = 100;

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final long id;
    private final String title;
    private final String description;
    private final TaskPriority priority;
    private final LocalDateTime createdAt;
    private TaskStatus status;

    public Task(long id, String title, String description, TaskPriority priority) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (title.trim().length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(
                    "title must not be longer than " + MAX_TITLE_LENGTH + " characters");
        }
        if (priority == null) {
            throw new IllegalArgumentException("priority must not be null");
        }

        this.id = id;
        this.title = title.trim();
        this.description = description == null ? "" : description.trim();
        this.priority = priority;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
    }

    public void start() {
        if (status != TaskStatus.TODO) {
            throw new IllegalStateException(
                    "Only TODO tasks can be started, current status: " + status);
        }
        status = TaskStatus.IN_PROGRESS;
    }

    public void complete(){
        if (status == TaskStatus.DONE){
           throw new IllegalStateException("Task is already completed");
        }
        status = TaskStatus.DONE;
    }

    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public TaskPriority getPriority(){
        return priority;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Task #%d%n" +
                "Title:       %s%n" +
                "Description: %s%n" +
                "Priority:    %s%n" +
                "Status:      %s%n" +
                "Created:     %s%n", id, title, description, priority, status,createdAt.format(DATE_FORMAT));
    }
}
