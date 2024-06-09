package TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTaskFrame extends JFrame {
    private JTextField taskNameField;
    private JTextField deadlineField;
    private JComboBox<String> priorityComboBox;
    private TaskManagerGUI mainGUI;

    public AddTaskFrame(TaskManagerGUI mainGUI) {
        this.mainGUI = mainGUI;
        setTitle("Add New Task");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Add new task: "));
        taskNameField = new JTextField();
        add(taskNameField);

        add(new JLabel("Deadline (yyyy-MM-dd): "));
        deadlineField = new JTextField();
        add(deadlineField);

        add(new JLabel("Priority: "));
        priorityComboBox = new JComboBox<>(new String[]{"High", "Low"});
        add(priorityComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = taskNameField.getText();
                String deadline = deadlineField.getText();
                String priority = (String) priorityComboBox.getSelectedItem();
                Task task = new Task(name, deadline, priority);
                if ("High".equals(priority)) {
                    task = new HighPriorityTask(task);
                }
                new AddTaskCommand(task).execute();
                mainGUI.updateHighPriorityTasksArea();
                dispose();
            }
        });
        add(confirmButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(backButton);
    }
}


