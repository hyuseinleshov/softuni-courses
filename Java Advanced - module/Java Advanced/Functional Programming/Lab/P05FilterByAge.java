package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.io.ObjectInputFilter.Config.createFilter;

public class P05FilterByAge {

    public static class Person {
        String name;
        int age;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");

            Person person = new Person();

            person.name = tokens[0];
            person.age = Integer.parseInt(tokens[1]);

            persons.add(person);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> filter = createFilter(condition, age);
        Consumer<Person> formatter = createFormat(format);

        persons.stream()
                .filter(filter)
                .forEach(formatter);
    }

    private static Consumer<Person> createFormat(String format) {

        if (format.equals("name")) {
            return person -> System.out.println(person.name);
        } else if (format.equals("age")) {
            return person -> System.out.println(person.age);
        }

        return person -> System.out.println(person.name + " - " + person.age);
    }

    private static Predicate<Person> createFilter(String condition, int age) {
        if (condition.equals("younger")) {
            Predicate<Person> filter = person -> person.age <= age;

            return filter;
        }

        Predicate<Person> filter = person -> person.age >= age;
            return filter;


    }
}
