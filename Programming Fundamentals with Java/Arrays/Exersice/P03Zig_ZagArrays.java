package Exersice;

import java.util.Scanner;

public class P03Zig_ZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {
            counter++;
            String[] numbers = scanner.nextLine().split(" ");
            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);

            if (counter % 2 == 0) {
                firstArray[i] = number1;
                secondArray[i] = number2;
            } else {
                secondArray[i] = number1;
                firstArray[i] = number2;
            }
        }
        for (int i = 0; i < secondArray.length; i++) {
            System.out.print(secondArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + " ");
        }
    }
}
