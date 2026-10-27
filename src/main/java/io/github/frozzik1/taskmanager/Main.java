package io.github.frozzik1.taskmanager;

public class Main {
    public static void main(String[] args) {
        final long taskId = 1l;
        final String title = "Set up Java development environment";
        final String description = "Install JDK 25, IntelliJ IDEA and Git";
        final int priority = 3;
        final double estimatedHours = 2.5;
        final boolean completed = true;
        String status = completed ? "[x] done" : "[ ] open";

        System.out.printf("=== Task Management System v0.1 ===%n");
        System.out.printf("Task#%d%n", taskId);
        System.out.printf("Title %s%n", title);
        System.out.printf("Description: %s%n", description);
        System.out.printf("Priority: %d / 5%n", priority);
        System.out.printf("Estimate: %.1f h%n", estimatedHours);
        System.out.printf("Status: %s%n", status);

        // NOTE: duplication, will be solved with classes (OOP block)

        final long taskId1 = 2l;
        final String title1 = "Second task";
        final String description1 = "Need to use OOP";
        final int priority1 = 5;
        final double estimatedHours1 = 1.5;
        final boolean completed1 = false;
        String status1 = completed1 ? "[x] done" : "[ ] open";

        System.out.printf("=== Task Management System v0.1.1 ===%n");
        System.out.printf("Task#%d%n", taskId1);
        System.out.printf("Title %s%n", title1);
        System.out.printf("Description: %s%n", description1);
        System.out.printf("Priority: %d / 5%n", priority1);
        System.out.printf("Estimate: %.1f h%n", estimatedHours1);
        System.out.printf("Status: %s%n", status1);
    }
}
