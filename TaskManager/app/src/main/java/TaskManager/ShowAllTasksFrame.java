package TaskManager;

import javax.swing.*;
import java.awt.*;

public class ShowAllTasksFrame extends JFrame {
    public ShowAllTasksFrame() {
        setTitle("Show All Tasks");
        setSize(300, 200);
        setLayout(new BorderLayout());

        JTextArea allTasksArea = new JTextArea();
        allTasksArea.setEditable(false);
        for (Task task : TaskManager.getInstance().getTasks()) {
            allTasksArea.append(task.getName() + " - " + task.getDeadline() + " - " + task.getPriority() + " - " + (task.isDone() ? "Done" : "Not Done") + "\n");
        }
        add(new JScrollPane(allTasksArea), BorderLayout.CENTER);
    }
}

