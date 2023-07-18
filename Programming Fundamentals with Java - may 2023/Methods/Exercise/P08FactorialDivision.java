package Exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        double result = calculateTheFactorial(firstNumber, secondNumber);
        System.out.printf("%.2f", result);
    }
    public static double calculateTheFactorial (int n1, int n2) {
        long firstNumberFactorial = 1;
        long secondNumberFactorial = 1;
        for (int i = 1; i <= n1 ; i++) {
            firstNumberFactorial = firstNumberFactorial * i;
        }
        for (int i = 1; i <= n2 ; i++) {
            secondNumberFactorial = secondNumberFactorial * i;
        }
        double result = firstNumberFactorial * 1.0 / secondNumberFactorial;
        return result;
    }
}
