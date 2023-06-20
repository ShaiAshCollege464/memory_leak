import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        University university = new University("Example University");
        Faculty faculty = new Faculty("Example Faculty");
        Course course = new Course("Example Course");

        faculty.addCourse(course);
        university.addFaculty(faculty);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            int times = 0;
            while (true) {
                Student student = new Student(); // Assume a constructor with random properties
                university.addStudent(student);
                course.addStudent(student);

                try {
                    if (times % 1000 == 0) {
                        Thread.sleep(100);
                    }
                    times++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

            }
        });

        executor.submit(() -> {
            int times = 0;
            while (true) {
                Student student = university.getStudents().peek();
                if (student != null) {
                    university.removeStudent(student);
                }

                try {
                    if (times % 1000 == 0) {
                        Thread.sleep(1);
                    }
                    times++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Runtime runtime = Runtime.getRuntime();
                long usedMemory = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Used Memory: " + usedMemory / 1024 / 1024 + " MB");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        executor.shutdown();
    }
}
