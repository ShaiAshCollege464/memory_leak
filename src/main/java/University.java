import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class University {
    private String name;
    private CopyOnWriteArrayList<Faculty> faculties = new CopyOnWriteArrayList<>();
    private ConcurrentLinkedQueue<Student> students = new ConcurrentLinkedQueue<>();

    public University(String name) {
        this.name = name;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        for (Faculty faculty : faculties) {
            for (Course course : faculty.getCourses().values()) {
                course.removeStudent(student);
            }
        }
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
        for (Course course : faculty.getCourses().values()) {
            faculty.removeCourse(course.getName());
        }
    }

    public ConcurrentLinkedQueue<Student> getStudents() {
        return students;
    }
}
