package TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTaskFrame extends JFrame {
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel;
    private TaskManagerGUI mainGUI;

    public RemoveTaskFrame(TaskManagerGUI mainGUI) {
        this.mainGUI = mainGUI;
        setTitle("Remove Task");
        setSize(300, 200);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        for (Task task : TaskManager.getInstance().getTasks()) {
            listModel.addElement(task);
        }

        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task selectedTask = taskList.getSelectedValue();
                if (selectedTask != null) {
                    new RemoveTaskCommand(selectedTask).execute();
                    listModel.removeElement(selectedTask);
                    mainGUI.updateHighPriorityTasksArea();
                }
            }
        });
        buttonPanel.add(confirmButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}


