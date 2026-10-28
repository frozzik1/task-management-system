package io.github.frozzik1.taskmanager;
import io.github.frozzik1.taskmanager.model.Task;
import io.github.frozzik1.taskmanager.model.TaskPriority;
import java.util.Scanner;

public class Main {
    private static final int MAX_PRIORITY = 5;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> listTasks();
                case 3 -> markTaskCompleted(scanner);
                case 4 -> deleteTask(scanner);
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

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Task Management System ===");
        System.out.println("1. Add task");
        System.out.println("2. List tasks");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Delete task");
        System.out.println("0. Exit");
    }
    private static void addTask(Scanner scanner) {
        System.out.println("Not implemented yet");
    }

    private static void listTasks() {
        System.out.println("Not implemented yet");
    }

    private static void markTaskCompleted(Scanner scanner){
        System.out.println("Not implemented yet");
    }

    private static void deleteTask(Scanner scanner){
        System.out.println("Not implemented yet");
    }
}