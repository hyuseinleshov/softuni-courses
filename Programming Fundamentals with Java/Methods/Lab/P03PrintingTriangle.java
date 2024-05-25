package Lab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printLine(Integer.parseInt(scanner.nextLine()));
    }
    public static void printLine (int n) {
        int number = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            number = 1;
            System.out.println();
        }
        for (int i = n - 1; i >= 1 ; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            number = 1;
            System.out.println();
        }
    }
}
