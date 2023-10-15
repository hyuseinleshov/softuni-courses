package Exercises.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);

            persons.add(person);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());

        Person comparatorPerson = persons.get(n - 1);

        int total = persons.size();
        int equal = 0;
        int notEqual = 0;

        int index = 0;
        for (Person person : persons) {

            if (index != n - 1) {
                if (person.compareTo(comparatorPerson) == 0) {
                    equal++;
                } else {
                    notEqual++;
                }
            }

            index++;
        }

        if (equal == 0) {
            System.out.println("No matches");
        } else {
            System.out.print(equal + 1 + " ");
            System.out.print(notEqual + " ");
            System.out.println(total);
        }

    }

}
