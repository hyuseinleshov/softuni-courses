package Lab;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= number ; i++) {
            int lastDigit = i % 10;
            int secondDigit = i / 10;
            sum = secondDigit + lastDigit;
            boolean isValid = sum == 5 || sum == 7 || sum == 11;
            if (isValid) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
