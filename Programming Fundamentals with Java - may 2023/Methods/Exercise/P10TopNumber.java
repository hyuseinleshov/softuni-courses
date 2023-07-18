package Exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopNumbers(n);
    }
    public static void printTopNumbers (int n) {
        for (int i = 8; i <= n ; i++) {
            int number = i;
            int sum = 0;
            int counter = 0;
            while (number > 0) {
                int lastDigit = number % 10;
                if (lastDigit % 2 != 0) {
                    counter++;
                }
                sum += lastDigit;
                number /= 10;
            }
            if (sum % 8 == 0 && counter > 0) {
                System.out.println(i);
            }
        }
    }
}
