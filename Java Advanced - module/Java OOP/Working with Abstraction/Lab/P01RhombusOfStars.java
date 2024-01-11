package Lab;

import java.util.Scanner;

public class P01RhombusOfStars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            printRows(n, i);
        }

        for (int i = n - 1; i >= 1; i--) {

            printRows(n, i);
        }


    }

    private static void printRows(int n, int i) {

        int leadingSpaces = n - i;

        for (int j = 0; j < leadingSpaces; j++) {

            System.out.print(" ");
        }

        for (int j = 0; j < i; j++) {

            System.out.print("* ");
        }

        System.out.println();
    }


}
