package io.github.frozzik1.taskmanager;
import io.github.frozzik1.taskmanager.exception.TaskNotFoundException;
import io.github.frozzik1.taskmanager.model.BugTask;
import io.github.frozzik1.taskmanager.model.FeatureTask;
import io.github.frozzik1.taskmanager.model.Task;
import io.github.frozzik1.taskmanager.model.TaskStatus;
import io.github.frozzik1.taskmanager.service.TaskManager;

public class Main {
    public static void main(String[] args) {
        Task bug = new BugTask("NullPointerException in AuthService", "Fix crash on login", "Critical");
        Task feature = new FeatureTask("First normal Task", "This is only start", 3);

        TaskManager manager = new TaskManager();
        manager.addTask(bug);
        manager.addTask(feature);
        System.out.println("=== ALL TASKS ===");
        manager.printAllTasks();
        System.out.println("=== Search result ===");
        Task foundTask = manager.findTaskById(1);
        System.out.println(foundTask);

        try {
            Task missingTask = manager.findTaskById(999);
            System.out.println(missingTask);
        } catch (TaskNotFoundException e) {
            System.out.println("Error caught: " + e.getMessage());
        }

    }
}
