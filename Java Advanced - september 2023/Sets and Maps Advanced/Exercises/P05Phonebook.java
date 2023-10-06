package Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");

            String name = tokens[0];
            String number = tokens[1];

            if (!phonebook.containsKey(name)) {
                phonebook.put(name, number);
            } else {
                phonebook.put(name, number);
            }

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("stop")) {
            String name = secondInput;

            if (!phonebook.containsKey(name)) {
                System.out.printf("Contact %s does not exist.%n", name);
            } else {
                System.out.println(name + " -> " + phonebook.get(name));
            }

            secondInput = scanner.nextLine();
        }
    }
}
