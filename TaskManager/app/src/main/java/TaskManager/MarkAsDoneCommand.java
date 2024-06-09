package TaskManager;

public class MarkAsDoneCommand implements Command {
    private Task task;

    public MarkAsDoneCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        task.setDone(true);
    }
}

