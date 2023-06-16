import java.util.concurrent.ConcurrentLinkedQueue;

public class Course {
    private String name;
    private ConcurrentLinkedQueue<Student> students = new ConcurrentLinkedQueue<>();

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

}