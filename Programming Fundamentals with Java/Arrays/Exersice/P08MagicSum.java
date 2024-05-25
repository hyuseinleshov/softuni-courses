package Exersice;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < numbersArray.length; i++) {
            int number = numbersArray[i];
            for (int j = i + 1; j < numbersArray.length; j++) {
                sum = number + numbersArray[j];
                if (magicNumber == sum) {
                    firstNum = number;
                    secondNum = numbersArray[j];
                    System.out.print(firstNum + " " + secondNum);
                    System.out.println();
                }
            }
        }
    }
}
