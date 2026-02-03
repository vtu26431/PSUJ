import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }
}

public class TopKStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            students.add(new Student(name, marks));
        }

        int k = sc.nextInt();

        students.stream()
                .sorted(
                        Comparator.comparing(Student::getMarks).reversed()
                                .thenComparing(Student::getName)
                )
                .limit(k)
                .map(Student::getName)
                .forEach(name -> System.out.print(name + " "));

        sc.close();
    }
}
