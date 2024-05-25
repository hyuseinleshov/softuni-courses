package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];

            if (command.equals("Add")) {
                int number = Integer.parseInt(commandArr[1]);
                numbersList.add(number);
            } else if (command.equals("Remove")) {
                int number = Integer.parseInt(commandArr[1]);
                numbersList.remove(Integer.valueOf(number));
            } else if (command.equals("RemoveAt")) {
                int index = Integer.parseInt(commandArr[1]);
                numbersList.remove(index);
            } else if (command.equals("Insert")) {
                int number = Integer.parseInt(commandArr[1]);
                int index = Integer.parseInt(commandArr[2]);
                numbersList.add(index, number);
            }
            input = scanner.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
