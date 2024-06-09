package TaskManager;

public class HighPriorityTask extends TaskDecorator {
    public HighPriorityTask(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public String getPriority() {
        return "High";
    }
}

