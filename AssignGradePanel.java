// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Map;

// public class AssignGradePanel extends JPanel {
//     private JComboBox<Student> studentDropdown;
//     private JComboBox<Course> courseDropdown;
//     private JTextField gradeField;
//     private JButton assignGradeButton;
//     private JTextArea gradeDisplayArea;

//     public AssignGradePanel() {
//         setLayout(new GridLayout(5, 2));

//         JLabel selectStudentLabel = new JLabel("Select Student:");
//         studentDropdown = new JComboBox<>();
//         refreshStudentDropdown();

//         JLabel selectCourseLabel = new JLabel("Select Course:");
//         courseDropdown = new JComboBox<>();
//         refreshCourseDropdown();

//         studentDropdown.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 refreshCourseDropdown();
//                 // displayGrades();
//             }
//         });

//         JLabel gradeLabel = new JLabel("Assign Grade:");
//         gradeField = new JTextField();

//         assignGradeButton = new JButton("Assign Grade");
//         assignGradeButton.addActionListener(new AssignGradeActionListener());

//         gradeDisplayArea = new JTextArea();
//         gradeDisplayArea.setEditable(false);

//         add(selectStudentLabel);
//         add(studentDropdown);
//         add(selectCourseLabel);
//         add(courseDropdown);
//         add(gradeLabel);
//         add(gradeField);
//         add(new JLabel());  // Empty label for spacing
//         add(assignGradeButton);
//         add(new JLabel("Grades:"));
//         add(new JScrollPane(gradeDisplayArea));
//     }

//     private void refreshStudentDropdown() {
//         studentDropdown.removeAllItems();
//         for (Student student : StudentManager.getAllStudents()) {
//             studentDropdown.addItem(student.getName());
//         }
//     }

//     private void refreshCourseDropdown() {
//         courseDropdown.removeAllItems();
//         // Student selectedStudent = (Student) studentDropdown.getSelectedItem();
//         // if (selectedStudent != null) {
//         //     for (Course course : CourseManager.getAllCourses()) {
//         //         courseDropdown.addItem(course);
//         //     }
//         // }
//         for (Course course : CourseManager.getAllCourses()) {
//             courseDropdown.addItem(course);
//         }
//     }

//     private void displayGrades() {
//         gradeDisplayArea.setText("");
//         Student selectedStudent = (Student) studentDropdown.getSelectedItem();
//         if (selectedStudent != null) {
//             Map<String, String> grades = GradeManager.getGradesForStudent(selectedStudent);
//             for (Map.Entry<String, String> entry : grades.entrySet()) {
//                 String courseName = null;
//                 for (Course course : CourseManager.getAllCourses()) {
//                     if (course.getCourseId().equals(entry.getKey())) {
//                         courseName = course.getCourseName();
//                         break;
//                     }
//                 }
//                 gradeDisplayArea.append(courseName + ": " + entry.getValue() + "\n");
//             }
//         }
//     }

//     private class AssignGradeActionListener implements ActionListener {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             Student selectedStudent = (Student) studentDropdown.getSelectedItem();
//             Course selectedCourse = (Course) courseDropdown.getSelectedItem();
//             String grade = gradeField.getText();

//             if (selectedStudent == null || selectedCourse == null || grade.isEmpty()) {
//                 JOptionPane.showMessageDialog(AssignGradePanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
//                 return;
//             }

//             GradeManager.assignGrade(selectedStudent, selectedCourse, grade);
//             JOptionPane.showMessageDialog(AssignGradePanel.this, "Grade assigned successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//             displayGrades();
//         }
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Map;

// public class AssignGradePanel extends JPanel {
//     private JComboBox<String> studentDropdown;
//     private JComboBox<Course> courseDropdown;
//     private JTextField gradeField;
//     private JButton assignGradeButton;
//     private JTextArea gradeDisplayArea;

//     public AssignGradePanel() {
//         setLayout(new GridLayout(5, 2));

//         JLabel selectStudentLabel = new JLabel("Select Student:");
//         studentDropdown = new JComboBox<>();
//         refreshStudentDropdown();

//         JLabel selectCourseLabel = new JLabel("Select Course:");
//         courseDropdown = new JComboBox<>();
//         refreshCourseDropdown();

//         studentDropdown.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 refreshCourseAndGrades();
//             }
//         });

//         JLabel gradeLabel = new JLabel("Assign Grade:");
//         gradeField = new JTextField();

//         assignGradeButton = new JButton("Assign Grade");
//         assignGradeButton.addActionListener(new AssignGradeActionListener());

//         gradeDisplayArea = new JTextArea();
//         gradeDisplayArea.setEditable(false);

//         add(selectStudentLabel);
//         add(studentDropdown);
//         add(selectCourseLabel);
//         add(courseDropdown);
//         add(gradeLabel);
//         add(gradeField);
//         add(new JLabel());  // Empty label for spacing
//         add(assignGradeButton);
//         add(new JLabel("Grades:"));
//         add(new JScrollPane(gradeDisplayArea));
//     }

//     private void refreshStudentDropdown() {
//         studentDropdown.removeAllItems();
//         for (Student student : StudentManager.getAllStudents()) {
//             studentDropdown.addItem(student);
//         }
//     }

//     private void refreshCourseDropdown() {
//         courseDropdown.removeAllItems();
//         for (Course course : CourseManager.getAllCourses()) {
//             courseDropdown.addItem(course);
//         }
//     }

//     private void refreshCourseAndGrades() {
//         gradeDisplayArea.setText("");
//         Student selectedStudentName = (Student) studentDropdown.getSelectedItem();
//         if (selectedStudentName != null) {
//             Student selectedStudent = null;
//             for (Student student : StudentManager.getAllStudents()) {
//                 if (student.getName().equals(selectedStudentName)) {
//                     selectedStudent = student;
//                     break;
//                 }
//             }
//             if (selectedStudent != null) {
//                 Map<String, String> grades = GradeManager.getGradesForStudent(selectedStudent);
//                 for (Map.Entry<String, String> entry : grades.entrySet()) {
//                     String courseName = null;
//                     for (Course course : CourseManager.getAllCourses()) {
//                         if (course.getCourseId().equals(entry.getKey())) {
//                             courseName = course.getCourseName();
//                             break;
//                         }
//                     }
//                     gradeDisplayArea.append(courseName + ": " + entry.getValue() + "\n");
//                 }
//             }
//         }
//     }

//     private class AssignGradeActionListener implements ActionListener {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             String selectedStudentName = (String) studentDropdown.getSelectedItem();
//             Course selectedCourse = (Course) courseDropdown.getSelectedItem();
//             String grade = gradeField.getText();

//             if (selectedStudentName == null || selectedCourse == null || grade.isEmpty()) {
//                 JOptionPane.showMessageDialog(AssignGradePanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
//                 return;
//             }

//             Student selectedStudent = null;
//             for (Student student : StudentManager.getAllStudents()) {
//                 if (student.getName().equals(selectedStudentName)) {
//                     selectedStudent = student;
//                     break;
//                 }
//             }

//             if (selectedStudent == null) {
//                 JOptionPane.showMessageDialog(AssignGradePanel.this, "Invalid student selected", "Error", JOptionPane.ERROR_MESSAGE);
//                 return;
//             }

//             GradeManager.assignGrade(selectedStudent, selectedCourse, grade);
//             JOptionPane.showMessageDialog(AssignGradePanel.this, "Grade assigned successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
//             refreshCourseAndGrades();
//         }
//     }
// }
/* 
        
        
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AssignGradePanel extends JPanel {
    private JComboBox<Student> studentDropdown;
    private JComboBox<Course> courseDropdown;
    private JTextField gradeField;
    private JButton assignGradeButton;
    private JTextArea gradeDisplayArea;

    public AssignGradePanel() {
        setLayout(new GridLayout(5, 2));

        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentDropdown = new JComboBox<>();
        refreshStudentDropdown();

        JLabel selectCourseLabel = new JLabel("Select Course:");
        courseDropdown = new JComboBox<>();
        refreshCourseDropdown();

        studentDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCourseAndGrades();
            }
        });

        JLabel gradeLabel = new JLabel("Assign Grade:");
        gradeField = new JTextField();

        assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new AssignGradeActionListener());

        gradeDisplayArea = new JTextArea();
        gradeDisplayArea.setEditable(false);

        add(selectStudentLabel);
        add(studentDropdown);
        add(selectCourseLabel);
        add(courseDropdown);
        add(gradeLabel);
        add(gradeField);
        add(new JLabel());  // Empty label for spacing
        add(assignGradeButton);
        add(new JLabel("Grades:"));
        add(new JScrollPane(gradeDisplayArea));
    }

    public void refreshStudentDropdown() {
        studentDropdown.removeAllItems();
        for (Student student : StudentManager.getAllStudents()) {
            studentDropdown.addItem(student);
        }
    }

    private void refreshCourseDropdown() {
        courseDropdown.removeAllItems();
        for (Course course : CourseManager.getAllCourses()) {
            courseDropdown.addItem(course);
        }
    }

    private void refreshCourseAndGrades() {
        gradeDisplayArea.setText("");
        Student selectedStudent = (Student) studentDropdown.getSelectedItem();
        if (selectedStudent != null) {
            Map<String, String> grades = GradeManager.getGradesForStudent(selectedStudent);
            for (Map.Entry<String, String> entry : grades.entrySet()) {
                String courseName = null;
                for (Course course : CourseManager.getAllCourses()) {
                    if (course.getCourseId().equals(entry.getKey())) {
                        courseName = course.getCourseName();
                        break;
                    }
                }
                gradeDisplayArea.append(courseName + ": " + entry.getValue() + "\n");
            }
        }
    }

    private class AssignGradeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student selectedStudent = (Student) studentDropdown.getSelectedItem();
            Course selectedCourse = (Course) courseDropdown.getSelectedItem();
            String grade = gradeField.getText();

            if (selectedStudent == null || selectedCourse == null || grade.isEmpty()) {
                JOptionPane.showMessageDialog(AssignGradePanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            GradeManager.assignGrade(selectedStudent, selectedCourse, grade);
            JOptionPane.showMessageDialog(AssignGradePanel.this, "Grade assigned successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshCourseAndGrades();
        }
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AssignGradePanel extends JPanel {
    private JComboBox<Student> studentDropdown;
    private JComboBox<Course> courseDropdown;
    private JTextField gradeField;
    private JButton assignGradeButton;
    private JTextArea gradeDisplayArea;

    public AssignGradePanel() {
        setLayout(new GridLayout(5, 2));

        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentDropdown = new JComboBox<>();
        refreshStudentDropdown();

        JLabel selectCourseLabel = new JLabel("Select Course:");
        courseDropdown = new JComboBox<>();
        refreshCourseDropdown();

        studentDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCourseAndGrades();
            }
        });

        JLabel gradeLabel = new JLabel("Assign Grade:");
        gradeField = new JTextField();

        assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(new AssignGradeActionListener());

        gradeDisplayArea = new JTextArea();
        gradeDisplayArea.setEditable(false);

        add(selectStudentLabel);
        add(studentDropdown);
        add(selectCourseLabel);
        add(courseDropdown);
        add(gradeLabel);
        add(gradeField);
        add(new JLabel());  // Empty label for spacing
        add(assignGradeButton);
        add(new JLabel("Grades:"));
        add(new JScrollPane(gradeDisplayArea));
    }

    public void refreshStudentDropdown() {
        studentDropdown.removeAllItems();
        for (Student student : StudentManager.getAllStudents()) {
            studentDropdown.addItem(student);
        }
    }

    private void refreshCourseDropdown() {
        courseDropdown.removeAllItems();
        for (Course course : CourseManager.getAllCourses()) {
            courseDropdown.addItem(course);
        }
    }

    private void refreshCourseAndGrades() {
        gradeDisplayArea.setText("");
        Student selectedStudent = (Student) studentDropdown.getSelectedItem();
        if (selectedStudent != null) {
            Map<String, String> grades = GradeManager.getGradesForStudent(selectedStudent);
            for (Map.Entry<String, String> entry : grades.entrySet()) {
                String courseName = CourseManager.getCourseById(entry.getKey()).getCourseName();
                gradeDisplayArea.append(courseName + ": " + entry.getValue() + "\n");
            }
        }
    }

    private class AssignGradeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Student selectedStudent = (Student) studentDropdown.getSelectedItem();
            Course selectedCourse = (Course) courseDropdown.getSelectedItem();
            String grade = gradeField.getText();

            if (selectedStudent == null || selectedCourse == null || grade.isEmpty()) {
                JOptionPane.showMessageDialog(AssignGradePanel.this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            GradeManager.assignGrade(selectedStudent, selectedCourse, grade);
            JOptionPane.showMessageDialog(AssignGradePanel.this, "Grade assigned successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshCourseAndGrades();
        }
    }
}
