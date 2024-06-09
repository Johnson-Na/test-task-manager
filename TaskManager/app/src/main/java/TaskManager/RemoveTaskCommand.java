package TaskManager;

public class RemoveTaskCommand implements Command {
    private Task task;

    public RemoveTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        TaskManager.getInstance().removeTask(task);
    }
}

