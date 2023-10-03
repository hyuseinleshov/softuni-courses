package Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> VIPQuests = new TreeSet<>();
        Set<String> regularQuests = new TreeSet<>();

        String command = scanner.nextLine();

        while (!command.equals("PARTY")) {
            String quest = command;

            if (Character.isDigit(quest.charAt(0))) {
                VIPQuests.add(quest);
            } else {
                regularQuests.add(quest);
            }

            command = scanner.nextLine();
        }

        String secondCommand = scanner.nextLine();

        while (!secondCommand.equals("END")) {
            String quest = secondCommand;

            if (VIPQuests.contains(quest)) {
                VIPQuests.remove(quest);
            } else if (regularQuests.contains(quest)) {
                regularQuests.remove(quest);
            }

            secondCommand = scanner.nextLine();
        }

        System.out.println(VIPQuests.size() + regularQuests.size());

        for (String vipQuest : VIPQuests) {
            System.out.println(vipQuest);
        }

        for (String regularQuest : regularQuests) {
            System.out.println(regularQuest);
        }
    }
}
