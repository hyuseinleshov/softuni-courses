package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double priceForJourney = 0;
        String country = "";
        String typeOfJourney = "";

        if (budget <= 100) {
            country = "Bulgaria";
            if (season.equals("summer")) {
                priceForJourney = budget * 0.30;
                typeOfJourney = "Camp";
            } else if (season.equals("winter")) {
                priceForJourney = budget * 0.70;
                typeOfJourney = "Hotel";
            }
        }
        if (budget > 100 && budget <= 1000) {
            country = "Balkans";
            if (season.equals("summer")) {
                priceForJourney = budget * 0.40;
                typeOfJourney = "Camp";
            } else if (season.equals("winter")) {
                priceForJourney = budget * 0.80;
                typeOfJourney = "Hotel";
            }
        }
        if (budget > 1000) {
            country = "Europe";
            priceForJourney = budget * 0.90;
            typeOfJourney = "Hotel";
        }
        System.out.printf("Somewhere in %s%n",country);
        System.out.printf("%s - %.2f",typeOfJourney,priceForJourney);
    }
}
