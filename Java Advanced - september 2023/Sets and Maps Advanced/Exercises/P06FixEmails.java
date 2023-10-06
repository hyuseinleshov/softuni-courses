package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> personEmails = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            String emailDomain = email.substring(email.length() - 3);

            if (emailDomain.contains("us") || emailDomain.contains("uk") || emailDomain.contains("com")) {

            } else {
                personEmails.put(name, email);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : personEmails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
