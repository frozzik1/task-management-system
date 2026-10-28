package io.github.frozzik1.taskmanager;
import io.github.frozzik1.taskmanager.exception.TaskNotFoundException;
import io.github.frozzik1.taskmanager.model.Task;
import io.github.frozzik1.taskmanager.model.TaskPriority;
import io.github.frozzik1.taskmanager.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> addTask(scanner, taskService);
                case 2 -> listTasks(taskService);
                case 3 -> startTask(scanner, taskService);
                case 4 -> completeTask(scanner, taskService);
                case 5 -> deleteTask(scanner, taskService);
                case 0 -> running = false;
                default -> System.out.println("Unknown option, try again.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = readInt(scanner, prompt);   // reuse the simple version
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Value must be between " + min + " and " + max + ".");
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Task Management System ===");
        System.out.println("1. Add task");
        System.out.println("2. List tasks");
        System.out.println("3. Start task");
        System.out.println("4. Complete task");
        System.out.println("5. Delete task");
        System.out.println("0. Exit");
    }
    private static void addTask(Scanner scanner, TaskService taskService) {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Description (optional): ");
        String description = scanner.nextLine();
        TaskPriority priority = readPriority(scanner);

        try {
            Task task = taskService.create(title, description, priority);
            System.out.println("Created task #" + task.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static TaskPriority readPriority(Scanner scanner) {
        TaskPriority[] priorities = TaskPriority.values();
        for (int i = 0; i < priorities.length; i++) {
            System.out.println((i + 1) + ". " + priorities[i]);
        }
        int choice = readInt(scanner, "Priority: ", 1, priorities.length);
        return priorities[choice - 1];
    }

    private static void startTask(Scanner scanner, TaskService taskService) {
        long id = readInt(scanner, "Task id: ");
        try {
            taskService.start(id);
            System.out.println("Task #" + id + " started.");
        } catch (TaskNotFoundException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listTasks(TaskService taskService){
        List<Task> tasks = taskService.findAll();
        if (tasks.isEmpty()){
            System.out.println("No tasks yet.");
            return;
        }
        for (Task task : tasks){
            System.out.println(task);
            System.out.println();
        }
    }

    private static void completeTask(Scanner scanner, TaskService taskService) {
        long id = readInt(scanner, "Task id: ");
        try {
            taskService.complete(id);
            System.out.println("Task #" + id + " completed.");
        } catch (TaskNotFoundException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void deleteTask(Scanner scanner, TaskService taskService) {
        long id = readInt(scanner, "Task id: ");
        try {
            taskService.delete(id);
            System.out.println("Task #" + id + " deleted.");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}