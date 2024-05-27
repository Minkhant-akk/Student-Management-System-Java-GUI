import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel {
    private JTextField nameField;
    private JTextField idField;

    public AddStudentPanel() {
        setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        idField = new JTextField();

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new AddStudentActionListener());

        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(new JLabel());  // Empty label for spacing
        add(addButton);
    }

    private class AddStudentActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String id = idField.getText();

            if (name.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(AddStudentPanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StudentManager.addStudent(new Student(id, name));

            JOptionPane.showMessageDialog(AddStudentPanel.this, "Student added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            nameField.setText("");
            idField.setText("");
        }
    }
}
