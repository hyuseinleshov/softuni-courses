package Exersices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String input = scanner.nextLine();
            String[] commandsArray = input.split(" ");
            String name = commandsArray[0];
            String command = commandsArray[2];

            if (command.equals("not")) {
                if (namesList.contains(name)) {
                    namesList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            } else {
                if (namesList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    namesList.add(name);
                }
            }
        }
        for (int i = 0; i < namesList.size(); i++) {
            System.out.println(namesList.get(i));
        }
    }
}
