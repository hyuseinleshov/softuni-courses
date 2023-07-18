package Exersise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCount = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double priceForOne = 0;

        if (day.equals("Friday")) {
            if (type.equals("Students")) {
                priceForOne = 8.45;
            } else if (type.equals("Business")) {
                priceForOne = 10.90;
            } else if (type.equals("Regular")) {
                priceForOne = 15;
            }
        }
        if (day.equals("Saturday")) {
            if (type.equals("Students")) {
                priceForOne = 9.80;
            } else if (type.equals("Business")) {
                priceForOne = 15.60;
            } else if (type.equals("Regular")) {
                priceForOne = 20;
            }
        }
        if (day.equals("Sunday")) {
            if (type.equals("Students")) {
                priceForOne = 10.46;
            } else if (type.equals("Business")) {
                priceForOne = 16;
            } else if (type.equals("Regular")) {
                priceForOne = 22.50;
            }
        }
        double totalPrice = priceForOne * groupCount;

        if (type.equals("Students")) {
            if (groupCount >= 30) {
                totalPrice = totalPrice - (totalPrice * 0.15);
            }
        }
        if (type.equals("Business")) {
            if (groupCount >= 100) {
                groupCount = groupCount - 10;
                totalPrice = groupCount * priceForOne;
            }
        }
        if (type.equals("Regular")) {
            if (groupCount >= 10 && groupCount <= 20) {
                totalPrice = totalPrice - (totalPrice * 0.05);
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
