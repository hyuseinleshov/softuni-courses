package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];

            if (command.equals("Contains")) {
                int number = Integer.parseInt(commandArr[1]);;
                if (numbersList.contains(number)) {
                    System.out.println("Yes");
                } else  {
                    System.out.println("No such number");
                }
            } else if (input.contains("even")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) % 2 == 0) {
                        System.out.print(numbersList.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (input.contains("odd")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) % 2 != 0) {
                        System.out.print(numbersList.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (command.equals("Get")) {
                int sum = 0;
                for (int i = 0; i < numbersList.size(); i++) {
                    sum += numbersList.get(i);
                }
                System.out.println(sum);
            } else if (command.equals("Filter")) {
                String condition = commandArr[1];
                int number = Integer.parseInt(commandArr[2]);;
                if (condition.equals("<")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) < number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (condition.equals(">")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) > number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (condition.equals(">=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) >= number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (condition.equals("<=")) {
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) <= number) {
                            System.out.print(numbersList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            }
            input = scanner.nextLine();
        }
    }
}
