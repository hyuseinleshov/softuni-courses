package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projectType = scanner.nextLine();
        int rowsCount = Integer.parseInt(scanner.nextLine());
        int columnsCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (projectType) {
            case "Premiere":
                price = 12;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5;
                break;
        }
        double totalPrice = rowsCount * columnsCount * price;
        System.out.printf("%.2f leva",totalPrice);

    }
}
