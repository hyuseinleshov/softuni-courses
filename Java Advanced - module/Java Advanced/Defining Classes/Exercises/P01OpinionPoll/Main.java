package Exercises.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            persons.add(person);
        }

        Predicate<Person> predicate = person -> person.getAge() > 30;

        persons.stream()
                .filter(predicate)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

    }

}
