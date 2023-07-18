package Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            if (command.equals("Add")) {
                int number = Integer.parseInt(commandArray[1]);
                wagons.add(number);
            } else {
                int passengers = Integer.parseInt(commandArray[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int sum = wagons.get(i) + passengers;
                    if (sum <= maxCapacity) {
                        wagons.set(i, sum);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i) + " ");
        }
    }
}
