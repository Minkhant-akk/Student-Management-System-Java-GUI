import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudentPanel extends JPanel {
    private JComboBox<Student> studentDropdown;
    private JTextField nameField;
    private JTextField idField;
    //change this
    private JButton updateButton;

    public UpdateStudentPanel() {
        setLayout(new GridLayout(4, 2));

        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentDropdown = new JComboBox<>();

        // Populate dropdown with student IDs or names
        //studentDropdown.addItem(student);
        refreshStudentDropdown();

        //change this
        studentDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentDropdown.getSelectedItem();
                if (selectedStudent != null) {
                    nameField.setText(selectedStudent.getName());
                    idField.setText(selectedStudent.getId());
                }
            }
        });

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        idField = new JTextField();

        updateButton = new JButton("Update Student");
        updateButton.addActionListener(new UpdateStudentActionListener());

        add(selectStudentLabel);
        add(studentDropdown);
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(new JLabel());  // Empty label for spacing
        add(updateButton);
    }

    public void refreshStudentDropdown() {
        studentDropdown.removeAllItems();
        for (Student student : StudentManager.getAllStudents()) {
            studentDropdown.addItem(student);
        }
    }

    private class UpdateStudentActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student selectedStudent = (Student) studentDropdown.getSelectedItem();
            if (selectedStudent == null) {
                JOptionPane.showMessageDialog(UpdateStudentPanel.this, "No student selected", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String newName = nameField.getText();
            String newId = idField.getText();

            if (newName.isEmpty() || newId.isEmpty()) {
                JOptionPane.showMessageDialog(UpdateStudentPanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Change this
            //StudentManager.updateStudent(selectedStudent.getId(), newName, newId);
            selectedStudent.setName(newName);
            selectedStudent.setId(newId);

            JOptionPane.showMessageDialog(UpdateStudentPanel.this, "Student updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            // refreshStudentDropdown();
        }
    }
}
