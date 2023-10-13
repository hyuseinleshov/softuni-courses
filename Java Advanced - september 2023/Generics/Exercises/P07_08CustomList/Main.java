package Exercises.P07_08CustomList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    String element = tokens[1];

                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);

                    customList.remove(index);
                    break;
                case "Contains":
                    String value = tokens[1];

                    System.out.println(customList.contains(value));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String secondElement = tokens[1];

                    System.out.println(customList.countGreaterThan(secondElement));
                    break;
                case "Max":
                    String max = customList.getMax();

                    System.out.println(max);
                    break;
                case "Min":
                    String min = customList.getMin();

                    System.out.println(min);
                    break;
                case "Sort":

                    customList.sort();
                    break;
                case "Print":

                    customList.print();
                    break;

            }

            input = scanner.nextLine();
        }

    }

}
