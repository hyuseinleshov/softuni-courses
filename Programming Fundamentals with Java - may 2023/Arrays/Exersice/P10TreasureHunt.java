package Exersice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String initialLoot = scanner.nextLine();
       List<String> initialLootList = Arrays.stream(initialLoot.split("\\|")).collect(Collectors.toList());

       String input = scanner.nextLine();

       while (!input.equals("Yohoho!")) {
           String[] commandsArray = input.split(" ");
           String command = commandsArray[0];

           if (command.equals("Loot")) {
               for (int i = 1; i < commandsArray.length; i++) {
                   if (!initialLootList.contains(commandsArray[i]) && !commandsArray[i].equals("Loot")) {
                       initialLootList.add(0, commandsArray[i]);
                   }
               }
           } else if (command.equals("Drop")) {
               int index = Integer.parseInt(commandsArray[1]);
               if (index >= 0 && index < initialLootList.size() - 1) {
               String element = initialLootList.get(index);
               initialLootList.remove(index);
               initialLootList.add(element);
               }
           } else if (command.equals("Steal")) {
               int count = Integer.parseInt(commandsArray[1]);
               List<String> removedItems = new ArrayList<>();
               for (int i = initialLootList.size() - count; i < initialLootList.size(); i++) {
                   removedItems.add(initialLootList.get(i));
               }
               for (int i = 0; i < removedItems.size(); i++) {
                   initialLootList.remove(removedItems.get(i));
               }
               System.out.println(String.join(", ", removedItems));
           }
           input = scanner.nextLine();
       }
       double averageTreasureGain = 0;
        for (int i = 0; i < initialLootList.size(); i++) {
            String element = initialLootList.get(i);
            averageTreasureGain += element.length();
        }
        averageTreasureGain /= initialLootList.size();
        if (initialLootList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }
    }
}
