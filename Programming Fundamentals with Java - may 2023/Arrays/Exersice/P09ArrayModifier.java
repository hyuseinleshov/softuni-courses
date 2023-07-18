package Exersice;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while(!command.equals("end")) {
            if (command.contains("swap")) {
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);
                int number = numbersArray[firstIndex];
                numbersArray[firstIndex] = numbersArray[secondIndex];
                numbersArray[secondIndex] = number;
            } else if (command.contains("multiply")) {
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);
                int product = numbersArray[firstIndex] * numbersArray[secondIndex];
                numbersArray[firstIndex] = product;
            } else if (command.equals("decrease")) {
                for (int i = 0; i < numbersArray.length; i++) {
                    numbersArray[i] = numbersArray[i] - 1;
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbersArray.length; i++) {
            if (i == numbersArray.length - 1) {
                System.out.print(numbersArray[i]);
                break;
            }
            System.out.print(numbersArray[i] + ", ");
        }
    }
}
