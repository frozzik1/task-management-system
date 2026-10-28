package io.github.frozzik1.taskmanager.service;
import io.github.frozzik1.taskmanager.exception.TaskNotFoundException;
import io.github.frozzik1.taskmanager.model.Task;
import io.github.frozzik1.taskmanager.model.TaskPriority;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public Task create(String title, String description, TaskPriority priority) {
        Task task = new Task(nextId, title, description, priority);
        nextId++;
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return List.copyOf(tasks);
    }

    public Task getById(long id){
        for (Task task : tasks){
            if (task.getId() == id){
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }
    public void start(long id){
        Task task = getById(id);
        task.start();
    }

    public void complete(long id){
        Task task = getById(id);
        task.complete();
    }
    public void delete(long id){
        Task task = getById(id);
        tasks.remove(task);
    }
}