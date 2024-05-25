package Exercise.P06OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personsList = new ArrayList<>();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person person = new Person(name, id, age);
            personsList.add(person);

            input = scanner.nextLine();

        }
        personsList.sort(Comparator.comparingInt(Person::getAge));

        for (int i = 0; i < personsList.size(); i++) {
            System.out.printf("%s with ID: %s is %d years old.%n", personsList.get(i).getName(), personsList.get(i).getId(), personsList.get(i).getAge());
        }
    }
}
