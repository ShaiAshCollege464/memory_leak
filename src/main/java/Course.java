import java.util.concurrent.ConcurrentLinkedQueue;

public class Course {
    private String name;
    private ConcurrentLinkedQueue<StudentData> students = new ConcurrentLinkedQueue<>();

    public Course(String name) {
        this.name = name;
    }


    public void addStudent(Student student) {
        StudentData studentData = new StudentData(student);
        students.add(studentData);
    }

    public void removeStudent(Student student) {
        StudentData studentData = new StudentData(student);
        students.remove(studentData);
    }
    public String getName() {
        return name;
    }

    public ConcurrentLinkedQueue<StudentData> getStudents() {
        return students;
    }
}
