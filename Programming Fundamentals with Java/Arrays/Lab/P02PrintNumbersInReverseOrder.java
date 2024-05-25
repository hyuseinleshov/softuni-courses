package Lab;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbersArray = new int[n];

        for (int i = 0; i < n; i++) {
            numbersArray[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(numbersArray[i] + " ");
        }
    }
}
