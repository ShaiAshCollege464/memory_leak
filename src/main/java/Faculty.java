import java.util.concurrent.ConcurrentHashMap;

public class Faculty {
    private String name;
    private ConcurrentHashMap<String, Course> courses = new ConcurrentHashMap<>();

    public Faculty(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.put(course.getName(), course);
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }

    public void removeCourse(String name) {
        courses.remove(name);
    }

    public ConcurrentHashMap<String, Course> getCourses() {
        return courses;
    }
}
