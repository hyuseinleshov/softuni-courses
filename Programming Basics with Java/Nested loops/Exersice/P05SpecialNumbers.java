package NestedLoops_Exersise;

import java.util.Scanner;

public class P05SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999 ; i++) {
            int firstDigit = i / 1000;
            int secondDigit = i / 100 % 10;
            int thirdDigit = i / 10 % 10;
            int fourthDigit = i % 10;
            if (secondDigit == 0 || thirdDigit == 0 || fourthDigit == 0) {
                continue;
            }


            boolean checkOne = n % firstDigit == 0;
            boolean checkTwo = n % secondDigit == 0 && secondDigit != 0;
            boolean checkThree = n % thirdDigit == 0 && thirdDigit != 0;
            boolean checkFour = n % fourthDigit == 0 && fourthDigit != 0;

            if (checkOne && checkTwo && checkThree && checkFour) {
                System.out.print(i + " ");
            }
        }
    }
}
