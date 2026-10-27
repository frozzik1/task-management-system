package io.github.frozzik1.taskmanager;
import io.github.frozzik1.taskmanager.model.BugTask;
import io.github.frozzik1.taskmanager.model.FeatureTask;
import io.github.frozzik1.taskmanager.model.Task;
import io.github.frozzik1.taskmanager.model.TaskStatus;

public class Main {
    public static void main(String[] args) {
        Task bug = new BugTask("NullPointerException in AuthService", "Fix crash on login", "Critical");

        System.out.println(bug);
        bug.setStatus(TaskStatus.IN_PROGRESS);
        System.out.println("Updated: " + bug);

        Task feature = new FeatureTask("First normal Task", "This is only start", 3);
        System.out.println(feature);
    }
}
