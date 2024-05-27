
// import javax.swing.*;
// import java.awt.*;

// public class MainWindow extends JFrame {
//     // changie this
//     private AddStudentPanel addStudentPanel;
//     private EnrollStudentPanel enrollStudentPanel;
//     private AssignGradePanel assignGradePanel;
//     private ViewStudentPanel viewStudentPanel;
//     private UpdateStudentPanel updateStudentPanel;

//     private CardLayout cardLayout;
//     private JPanel mainPanel;

//     public MainWindow() {
//         setTitle("Student Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         //change this
//         setLayout(new BorderLayout());
//         JTabbedPane tabbedPane = new JTabbedPane();
//         addStudentPanel = new AddStudentPanel();
//         enrollStudentPanel = new EnrollStudentPanel();
//         assignGradePanel = new AssignGradePanel();
//         viewStudentPanel = new ViewStudentPanel();
//         updateStudentPanel = new UpdateStudentPanel();

//         tabbedPane.addTab("Add Student", addStudentPanel);
//         tabbedPane.addTab("Enroll Student", enrollStudentPanel);
//         tabbedPane.addTab("Assign Grade", assignGradePanel);
//         tabbedPane.addTab("View Students", viewStudentPanel);
//         tabbedPane.addTab("Update Student", updateStudentPanel);

//         add(tabbedPane, BorderLayout.CENTER);

//         /////////////////////////
//         JMenuBar menuBar = new JMenuBar();
//         JMenu studentMenu = new JMenu("Students");
//         JMenuItem addStudentItem = new JMenuItem("Add Student");
//         JMenuItem updateStudentItem = new JMenuItem("Update Student");
//         JMenuItem viewStudentDetailsItem = new JMenuItem("View Student Details");
//         JMenuItem enrollStudentItem = new JMenuItem("Enroll Student");
//         JMenuItem assignGradeItem = new JMenuItem("Assign Grade");

//         addStudentItem.addActionListener(e -> showCard("addStudentPanel"));
//         updateStudentItem.addActionListener(e -> showCard("updateStudentPanel"));
//         viewStudentDetailsItem.addActionListener(e -> showCard("viewStudentPanel"));
//         enrollStudentItem.addActionListener(e -> showCard("enrollStudentPanel"));
//         assignGradeItem.addActionListener(e -> showCard("assignGradePanel"));

//         studentMenu.add(addStudentItem);
//         studentMenu.add(updateStudentItem);
//         studentMenu.add(viewStudentDetailsItem);
//         studentMenu.add(enrollStudentItem);
//         studentMenu.add(assignGradeItem);
//         menuBar.add(studentMenu);

//         setJMenuBar(menuBar);

//         cardLayout = new CardLayout();
//         mainPanel = new JPanel(cardLayout);

//         mainPanel.add(new AddStudentPanel(), "addStudentPanel");
//         mainPanel.add(new UpdateStudentPanel(), "updateStudentPanel");
//         mainPanel.add(new ViewStudentPanel(), "viewStudentPanel");
//         mainPanel.add(new EnrollStudentPanel(), "enrollStudentPanel");
//         mainPanel.add(new AssignGradePanel(), "assignGradePanel");

//         add(mainPanel);
//     }

//     private void showCard(String cardName) {
//         cardLayout.show(mainPanel, cardName);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             MainWindow mainWindow = new MainWindow();
//             mainWindow.setVisible(true);
//         });
//     }
// }


        
// import javax.swing.*;
// import java.awt.*;

// public class MainWindow extends JFrame {
//     private AddStudentPanel addStudentPanel;
//     private EnrollStudentPanel enrollStudentPanel;
//     private AssignGradePanel assignGradePanel;
//     private ViewStudentPanel viewStudentPanel;
//     private UpdateStudentPanel updateStudentPanel;

//     public MainWindow() {
//         setTitle("Student Management System");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         CourseManager.addCourse(new Course("CS1101","Python"));
//         CourseManager.addCourse(new Course("CS1102","Java"));

//         JTabbedPane tabbedPane = new JTabbedPane();

//         addStudentPanel = new AddStudentPanel();
//         enrollStudentPanel = new EnrollStudentPanel();
//         assignGradePanel = new AssignGradePanel();
//         viewStudentPanel = new ViewStudentPanel();
//         updateStudentPanel = new UpdateStudentPanel();

//         tabbedPane.addTab("Add Student", addStudentPanel);
//         tabbedPane.addTab("Enroll Course", enrollStudentPanel);
//         tabbedPane.addTab("View Students", viewStudentPanel);
//         tabbedPane.addTab("Update Student", updateStudentPanel);
//         tabbedPane.addTab("Assign Grade", assignGradePanel);

//         add(tabbedPane, BorderLayout.CENTER);

//         // Refresh the ViewStudentPanel whenever the tab is selected
//         tabbedPane.addChangeListener(e -> {
//             if (tabbedPane.getSelectedComponent() == viewStudentPanel) {
//                 viewStudentPanel.refresh();
//             }
//             if (tabbedPane.getSelectedComponent() == enrollStudentPanel) {
//                 enrollStudentPanel.refreshCourseDropdown();
//                 enrollStudentPanel.refreshStudentDropdown();
//             }
//             if (tabbedPane.getSelectedComponent() == updateStudentPanel) {
//                 updateStudentPanel.refreshStudentDropdown();
//             }
//         });
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             MainWindow mainWindow = new MainWindow();
//             mainWindow.setVisible(true);
//         });
//     }
// }
/* 
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
*/
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

