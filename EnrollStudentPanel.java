import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollStudentPanel extends JPanel {
    private JComboBox<Course> courseDropdown;
    private JComboBox<Student> studentDropdown;
    private JButton enrollButton;

    public EnrollStudentPanel() {
        setLayout(new GridLayout(3, 2));

        JLabel selectCourseLabel = new JLabel("Select Course:");
        courseDropdown = new JComboBox<>();
        refreshCourseDropdown();

        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentDropdown = new JComboBox<>();
        refreshStudentDropdown();

        enrollButton = new JButton("Enroll Student");
        enrollButton.addActionListener(new EnrollStudentActionListener());

        add(selectCourseLabel);
        add(courseDropdown);
        add(selectStudentLabel);
        add(studentDropdown);
        add(new JLabel());  // Empty label for spacing
        add(enrollButton);
    }

    public void refreshCourseDropdown() {
        courseDropdown.removeAllItems();
        for (Course course : CourseManager.getAllCourses()) {
            courseDropdown.addItem(course);
        }
    }

    public void refreshStudentDropdown() {
        studentDropdown.removeAllItems();
        for (Student student : StudentManager.getAllStudents()) {
            studentDropdown.addItem(student);
        }
    }

    private class EnrollStudentActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Course selectedCourse = (Course) courseDropdown.getSelectedItem();
            Student selectedStudent = (Student) studentDropdown.getSelectedItem();

            if (selectedCourse == null || selectedStudent == null) {
                JOptionPane.showMessageDialog(EnrollStudentPanel.this, "Both course and student must be selected", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CourseManager.enrollStudentInCourse(selectedStudent, selectedCourse);

            JOptionPane.showMessageDialog(EnrollStudentPanel.this, "Student enrolled successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
