import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
