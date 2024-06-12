package TaskManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerGUI extends JFrame {
    private TaskManager taskManager;
    private JTextArea highPriorityTasksArea;

    public TaskManagerGUI() {
        taskManager = TaskManager.getInstance();
        setTitle("Task Manager");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        JButton addTaskButton = new JButton("Add New Task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTaskFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(addTaskButton);
        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        JButton removeTaskButton = new JButton("Remove Task");
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveTaskFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(removeTaskButton);
        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        JButton markAsDoneButton = new JButton("Mark as Done");
        markAsDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MarkAsDoneFrame(TaskManagerGUI.this).setVisible(true);
            }
        });
        panel.add(markAsDoneButton);
        panel.add(Box.createRigidArea(new Dimension(30, 30)));

        JButton showAllTasksButton = new JButton("Show All Tasks");
        showAllTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowAllTasksFrame().setVisible(true);
            }
        });
        panel.add(showAllTasksButton);
        panel.add(Box.createRigidArea(new Dimension(30, 30)));


        add(panel, BorderLayout.WEST);

        highPriorityTasksArea = new JTextArea(30, 0);
        JScrollPane scrollPane = new JScrollPane(highPriorityTasksArea);
        highPriorityTasksArea.setEditable(false);
        
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));
    
        updateHighPriorityTasksArea();
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateHighPriorityTasksArea() {
        highPriorityTasksArea.add(Box.createRigidArea(new Dimension(30, 30)));
        highPriorityTasksArea.setText("High Priority Task: \n");
        for (Task task : taskManager.getTasks()) {
            if ("High".equals(task.getPriority()) && !task.isDone()) {
                highPriorityTasksArea.append("* " + task.getName() + " " + task.getDeadline() + "\n");
            }
        }
    }
}


