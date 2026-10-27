package io.github.frozzik1.taskmanager.model;

public class BugTask extends Task {
    private String severity;

    public BugTask(String title, String description, String severity) {
        super(title, description);
        this.severity = severity;
    }

    @Override
    public String getTaskType() {
        return "BUG";
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return super.toString() + " | Severity: " + severity;
    }
}