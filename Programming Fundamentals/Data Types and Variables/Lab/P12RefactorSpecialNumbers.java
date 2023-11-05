package Lab;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        boolean isSpecialNumber = false;

        for (int i = 1; i <= n; i++) {

            int secondDigit = i % 10;
            int firstDigit = i / 10;
            sum = secondDigit + firstDigit;

            isSpecialNumber = (sum == 5) || (sum == 7) || (sum == 11);

            if (isSpecialNumber) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
            sum = 0;
        }
    }
}
