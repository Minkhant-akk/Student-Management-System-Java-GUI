import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager {
    private static List<Course> courses = new ArrayList<>();
    private static Map<Course, List<Student>> courseEnrollments = new HashMap<>();

    public static void addCourse(Course course) {
        courses.add(course);
        courseEnrollments.put(course, new ArrayList<>());
    }

    public static List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public static void enrollStudentInCourse(Student student, Course course) {
        List<Student> studentsInCourse = courseEnrollments.get(course);
        if (studentsInCourse != null && !studentsInCourse.contains(student)) {
            studentsInCourse.add(student);
        }
    }

    public static List<Student> getStudentsInCourse(Course course) {
        return courseEnrollments.getOrDefault(course, new ArrayList<>());
    }

    public static List<Student> getStudentsInCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return getStudentsInCourse(course);
            }
        }
        return new ArrayList<>();
    }

    public static Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
