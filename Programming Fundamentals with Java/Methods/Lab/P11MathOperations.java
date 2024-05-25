package Lab;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = result(Integer.parseInt(scanner.nextLine()), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));

        System.out.println(result);
    }
    public static int result (int first, String operator, int second) {
        int result = 0;
        if (operator.equals("/")) {
            result = first / second;
        } else if (operator.equals("*")) {
            result = first * second;
        } else if (operator.equals("+")) {
            result = first + second;
        } else if (operator.equals("-")) {
            result = first - second;
        }
        return result;
    }
}
