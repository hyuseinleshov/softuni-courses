package Exercises;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(number + 1));
    }

    public static long getFibonacci(int number) {
        if (number <= 0) {
            return 0; // Return 0 for invalid input.
        } else if (number == 1) {
            return 1; // Special case for the first Fibonacci number.
        } else {
            long prev = 1;
            long current = 1;

            for (int i = 2; i < number; i++) {
                long nextFibonacci = prev + current;
                prev = current;
                current = nextFibonacci;
            }

            return current; // The last Fibonacci number in the sequence.
        }
    }
}
