package TaskManager;

public abstract class TaskDecorator extends Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        super(decoratedTask.getName(), decoratedTask.getDeadline(), decoratedTask.getPriority());
        this.decoratedTask = decoratedTask;
    }
}

