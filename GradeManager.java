    import java.util.HashMap;
    import java.util.Map;

    public class GradeManager {
        private static Map<String, Map<String, String>> studentGrades = new HashMap<>();

        public static void assignGrade(Student student, Course course, String grade) {
            Map<String, String> grades = studentGrades.getOrDefault(student.getId(), new HashMap<>());
            grades.put(course.getCourseId(), grade);
            studentGrades.put(student.getId(), grades);
        }

        public static Map<String, String> getGradesForStudent(Student student) {
            return studentGrades.getOrDefault(student.getId(), new HashMap<>());
        }
    }
