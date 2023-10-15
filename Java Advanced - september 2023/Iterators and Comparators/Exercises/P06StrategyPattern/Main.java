package Exercises.P06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Person> nameSet = new TreeSet<>(new Person.NameComparator());
        Set<Person> ageSet = new TreeSet<>(new Person.AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            nameSet.add(person);
            ageSet.add(person);

        }

        nameSet.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
        ageSet.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

    }

}
