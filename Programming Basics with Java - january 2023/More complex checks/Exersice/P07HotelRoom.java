package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double priceForApartment = 0;
        double priceForStudio = 0;

        double discountForStudio = 0;
        double discountForApartment = 0;

        if (month.equals("May") || month.equals("October")) {
            priceForStudio = 50;
            priceForApartment = 65;
            if (nights > 14) {
                priceForStudio = priceForStudio - (priceForStudio * 0.30);
            } else if (nights > 7) {
                priceForStudio = priceForStudio - (priceForStudio * 0.05);
            }
        }
        if (month.equals("June") || month.equals("September")) {
            priceForStudio = 75.20;
            priceForApartment = 68.70;
            if (nights > 14) {
                priceForStudio = priceForStudio - (priceForStudio * 0.20);
            }
        }
        if (month.equals("July") || month.equals("August")) {
            priceForStudio = 76;
            priceForApartment = 77;
        }
        if (nights > 14) {
            priceForApartment = priceForApartment - (priceForApartment * 0.10);
        }
        double totalForStudio = nights * priceForStudio;
        double totalForApartment = nights * priceForApartment;

        System.out.printf("Apartment: %.2f lv.%n",totalForApartment);
        System.out.printf("Studio: %.2f lv.",totalForStudio);
    }
}
