package TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerGUI extends JFrame {
    private TaskManager taskManager;
    private JTextArea highPriorityTasksArea;

    public TaskManagerGUI() {
        taskManager = TaskManager.getInstance();
        setTitle("Task Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome to TaskManager");
        panel.add(welcomeLabel);

        JButton addTaskButton = new JButton("Add New Task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTaskFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(addTaskButton);

        JButton removeTaskButton = new JButton("Remove Task");
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveTaskFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(removeTaskButton);

        JButton markAsDoneButton = new JButton("Mark as Done");
        markAsDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MarkAsDoneFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(markAsDoneButton);

        JButton showAllTasksButton = new JButton("Show All Tasks");
        showAllTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowAllTasksFrame().setVisible(true);
            }
        });
        panel.add(showAllTasksButton);

        add(panel, BorderLayout.WEST);

        highPriorityTasksArea = new JTextArea();
        highPriorityTasksArea.setEditable(false);
        updateHighPriorityTasksArea();
        add(new JScrollPane(highPriorityTasksArea), BorderLayout.CENTER);
    }

    public void updateHighPriorityTasksArea() {
        highPriorityTasksArea.setText("High Priority task: ");
        for (Task task : taskManager.getTasks()) {
            if ("High".equals(task.getPriority()) && !task.isDone()) {
                highPriorityTasksArea.append(task.getName() + task.getDeadline() + "\n");
            }
        }
    }
}

