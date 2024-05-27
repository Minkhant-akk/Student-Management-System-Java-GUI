import javax.swing.*;
import java.awt.*;

public class ViewStudentPanel extends JPanel {
    private JTable studentTable;
    private StudentTableModel studentTableModel;

    public ViewStudentPanel() {
        setLayout(new BorderLayout());

        studentTableModel = new StudentTableModel(StudentManager.getAllStudents());
        studentTable = new JTable(studentTableModel);

        add(new JScrollPane(studentTable), BorderLayout.CENTER);
    }
    //change this
    public void refresh() {
        studentTableModel.setStudents(StudentManager.getAllStudents());
    }
}
