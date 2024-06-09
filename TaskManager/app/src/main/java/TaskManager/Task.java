package TaskManager;

public class Task {
    private String name;
    private String deadline;
    private String priority;
    private boolean isDone;

    public Task(String name, String deadline, String priority) {
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return name + " - " + deadline + " - " + priority + " - " + (isDone ? "Done" : "Not Done");
    }
}

