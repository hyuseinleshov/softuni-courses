package Exersise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int totalAmount = 0;

        while (startingYield >= 100) {
            days++;
            int totalExtractOfDay = startingYield - 26;
            totalAmount += totalExtractOfDay;
            startingYield -= 10;
        }
        if (totalAmount < 26) {

        } else {
            totalAmount -= 26;
        }
        System.out.println(days);
        System.out.print(totalAmount);
    }
}
