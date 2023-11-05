package Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate;

        List<String> quests = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String secondCommand = tokens[1];
            String criteria = tokens[2];

                if (secondCommand.equals("StartsWith")) {
                    predicate = s -> s.startsWith(criteria);
                } else if (secondCommand.equals("EndsWith")) {
                    predicate = s -> s.endsWith(criteria);
                } else {
                    predicate = s -> s.length() == Integer.parseInt(criteria);
                }

                switch (command) {
                    case "Remove":

                        quests.removeIf(predicate);
                        break;
                    case "Double":

                        List<String> questsToDouble = quests.stream()
                                .filter(predicate)
                                .collect(Collectors.toList());

                        quests.addAll(questsToDouble);
                        break;
                }

            input = scanner.nextLine();
        }

        if (quests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = quests.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!";

            System.out.println(result);
        }
    }

}
