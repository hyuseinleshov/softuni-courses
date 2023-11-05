package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String commands = scanner.nextLine();
            String[] commandsArray = commands.split(" ");
            String command = commandsArray[0];
            String username = commandsArray[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = commandsArray[2];
                    if (users.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        users.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (users.containsKey(username)) {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }
        users.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
