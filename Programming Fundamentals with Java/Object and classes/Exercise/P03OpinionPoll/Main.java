package Exercise.P03OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String personData = scanner.nextLine();
            String name = personData.split(" ")[0];
            int age = Integer.parseInt(personData.split(" ")[1]);
            Person person = new Person(name, age);

            if (age > 30) {
                System.out.printf("%s - %d%n", person.getName(), person.getAge());
            }
        }
    }
}
