package Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];

            if (command.equals("Add")) {
                numbersList.add(Integer.parseInt(commandArray[1]));
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(commandArray[2]);
                if (index > numbersList.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbersList.add(index, Integer.parseInt(commandArray[1]));
                }
            } else if (command.equals("Remove")) {
                if ((Integer.parseInt(commandArray[1]) > numbersList.size() - 1) || Integer.parseInt(commandArray[1]) < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbersList.remove(Integer.parseInt(commandArray[1]));
                }
            } else if (command.equals("Shift")) {
                String direction = commandArray[1];
                int count = Integer.parseInt(commandArray[2]);
                if (direction.equals("left")) {
                    for (int i = 0; i < count; i++) {
                        int firstNum = numbersList.get(0);
                        numbersList.remove(0);
                        numbersList.add(firstNum);
                    }
                } else if (direction.equals("right")) {
                    for (int i = 0; i < count; i++) {
                        int lastNum = numbersList.get(numbersList.size() - 1);
                        numbersList.remove(numbersList.size() - 1);
                        numbersList.add(0, lastNum);
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
    }
}
