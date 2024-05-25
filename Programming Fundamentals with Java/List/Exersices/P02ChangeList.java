package Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandsArray = input.split(" ");
            String command = commandsArray[0];
            int number = Integer.parseInt(commandsArray[1]);

            if (command.equals("Delete")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == number) {
                        numbers.remove(i);
                    }
                }
            } else if (command.equals("Insert")){
                int position = Integer.parseInt(commandsArray[2]);
                numbers.add(position, number);
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
