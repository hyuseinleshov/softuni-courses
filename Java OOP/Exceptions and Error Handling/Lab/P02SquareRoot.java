package Lab;

import java.util.Map;
import java.util.Scanner;

public class P02SquareRoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 0) {
                System.out.println("Invalid");
            } else {
                double squareRoot = Math.sqrt(num);
                System.out.printf("%.2f\n", squareRoot);
            }

        } catch (NumberFormatException ex) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }

}
