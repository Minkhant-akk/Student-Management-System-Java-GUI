import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private AddStudentPanel addStudentPanel;
    private EnrollStudentPanel enrollStudentPanel;
    private AssignGradePanel assignGradePanel;
    private ViewStudentPanel viewStudentPanel;
    private UpdateStudentPanel updateStudentPanel;

    public MainWindow() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        CourseManager.addCourse(new Course("CS1101", "Python"));
        CourseManager.addCourse(new Course("CS1102", "Java"));

        JTabbedPane tabbedPane = new JTabbedPane();

        addStudentPanel = new AddStudentPanel();
        enrollStudentPanel = new EnrollStudentPanel();
        assignGradePanel = new AssignGradePanel();
        viewStudentPanel = new ViewStudentPanel();
        updateStudentPanel = new UpdateStudentPanel();

        tabbedPane.addTab("Add Student", addStudentPanel);
        tabbedPane.addTab("Enroll Course", enrollStudentPanel);
        tabbedPane.addTab("Assign Grade", assignGradePanel);
        tabbedPane.addTab("Update Student", updateStudentPanel);
        tabbedPane.addTab("View Students", viewStudentPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Refresh the ViewStudentPanel whenever the tab is selected
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedComponent() == viewStudentPanel) {
                viewStudentPanel.refresh();
            }
            if (tabbedPane.getSelectedComponent() == enrollStudentPanel) {
                enrollStudentPanel.refreshCourseDropdown();
                enrollStudentPanel.refreshStudentDropdown();
            }
            if (tabbedPane.getSelectedComponent() == updateStudentPanel) {
                updateStudentPanel.refreshStudentDropdown();
            }
            if (tabbedPane.getSelectedComponent() == assignGradePanel) {
                assignGradePanel.refreshStudentDropdown();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}

