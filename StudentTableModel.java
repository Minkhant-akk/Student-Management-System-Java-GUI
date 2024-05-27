import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Map;

public class StudentTableModel extends AbstractTableModel {
    private List<Student> students;
    private String[] columnNames = {"Student ID", "Name", "Course", "Grade"};

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        int rowCount = 0;
        for (Student student : students) {
            rowCount += GradeManager.getGradesForStudent(student).size();
        }
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int currentIndex = 0;
        for (Student student : students) {
            Map<String, String> grades = GradeManager.getGradesForStudent(student);
            for (Map.Entry<String, String> entry : grades.entrySet()) {
                if (currentIndex == rowIndex) {
                    switch (columnIndex) {
                        case 0:
                            return student.getId();
                        case 1:
                            return student.getName();
                        case 2:
                            Course course = CourseManager.getCourseById(entry.getKey());
                            return course != null ? course.getCourseName() : "Unknown Course";
                        case 3:
                            return entry.getValue();
                        default:
                            return null;
                    }
                }
                currentIndex++;
            }
        }
        return null;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }
}
