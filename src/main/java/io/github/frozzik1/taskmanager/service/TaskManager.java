package io.github.frozzik1.taskmanager.service;
import io.github.frozzik1.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void printAllTasks(){
        for (Task task : tasks){
            System.out.println(task);
        }
    }

    public Task findTaskById(int id){
        for (Task task : tasks){
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }
}
