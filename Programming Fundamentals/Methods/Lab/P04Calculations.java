package Lab;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        if (command.equals("add")) {
            printAdd(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        } else if (command.equals("multiply")) {
            printMultiply(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        } else if (command.equals("subtract")) {
            printSubtract(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        } else {
            printDivide(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        }

    }
    public static void printAdd (int first, int second) {
        int result = first + second;
        System.out.println(result);
    }
    public static void printSubtract (int first, int second) {
        int result = first - second;
        System.out.println(result);
    }
    public static void printDivide (int first, int second) {
        int result = first / second;
        System.out.println(result);
    }
    public static void printMultiply (int first, int second) {
        int result = first * second;
        System.out.println(result);
    }
}
