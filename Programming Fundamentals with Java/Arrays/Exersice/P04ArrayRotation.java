package Exersice;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String firstElement = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
