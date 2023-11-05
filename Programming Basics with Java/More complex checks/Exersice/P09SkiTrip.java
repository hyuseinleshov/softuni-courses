package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String typeRoom = scanner.nextLine();
        String rating = scanner.nextLine();

        int nights = days - 1;
        double price = 0;
        double discount = 0;

        switch (typeRoom) {
            case "room for one person":
                price = 18;
                break;
            case "apartment":
                price = 25;
                if (nights < 10) {
                    discount = 0.3;
                } else if (nights > 10 && nights <= 15) {
                    discount = 0.35;
                } else if (nights > 15) {
                    discount = 0.50;
                }
                break;
            case "president apartment":
                price = 35;
                if (nights < 10) {
                    discount = 0.1;
                } else if (nights > 10 && nights <= 15) {
                    discount = 0.15;
                } else if (nights > 15) {
                    discount = 0.20;
                }
                break;
        }
        double total = (nights * price) - ((nights * price) * discount);
        if (rating.equals("positive")) {
            total = total + (total * 0.25);
        } else {
            total = total - (total * 0.1);
        }
        System.out.printf("%.2f",total);
    }
}
