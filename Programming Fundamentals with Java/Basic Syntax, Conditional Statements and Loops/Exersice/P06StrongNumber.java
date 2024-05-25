package Exersise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int number2 = number;
        int sum = 0;
        int sumFact = 1;
        int factorial = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            for (int i = 1; i < lastDigit ; i++) {
                factorial = sumFact * i;
                sumFact = sumFact + factorial;
                factorial = 0;
            }
            sum += sumFact;
            sumFact = 1;
            number = number / 10;
        }
        if (sum == number2) {
            System.out.println("yes");
        } else  {
            System.out.println("no");
        }
    }
}
