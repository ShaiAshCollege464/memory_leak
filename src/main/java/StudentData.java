import java.util.Objects;

public class StudentData {
    private Student student;

    public StudentData(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StudentData that = (StudentData) obj;
        return Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student);
    }
}
