package io.github.frozzik1.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(long id) {
        super("Task not found: " + id);
    }
}
