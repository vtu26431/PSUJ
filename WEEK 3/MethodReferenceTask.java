import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    // Static method for filtering
    static boolean isOlderThanLimit(Person p, int ageLimit) {
        return p.age > ageLimit;
    }
}

public class MethodReferenceTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        // 1. Sort alphabetically by name (method reference)
        persons.stream()
                .map(Person::getName)
                .sorted(String::compareTo)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 2. Filter persons older than ageLimit (static method reference)
        persons.stream()
                .filter(p -> Person.isOlderThanLimit(p, ageLimit))
                .map(Person::getName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 3. Convert all names to uppercase (instance method reference)
        persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));

        sc.close();
    }
}
