package NestedLoops_Exersise;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum ; i++) {
            int one = i / 100000 % 10;
            int two = i / 10000 % 10;
            int three = i / 1000 % 10;
            int four = i / 100 % 10;
            int five = i / 10 % 10;
            int six = i % 10;

            int oddSum = one + three + five;
            int evenSum = two + four + six;

            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
