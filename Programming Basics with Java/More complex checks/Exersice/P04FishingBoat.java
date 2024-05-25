package MoreComplexChecks_Exersise;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupBudget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishersCount = Integer.parseInt(scanner.nextLine());

        double priceForBoat = 0;
        double discount = 0;
        boolean discountSeasons = season.equals("Spring") || season.equals("Summer") || season.equals("Winter");

        switch (season) {
            case "Spring":
                priceForBoat = 3000;
                break;
            case "Summer":
            case "Autumn":
                priceForBoat = 4200;
                break;
            case "Winter":
                priceForBoat = 2600;
                break;
        }
        if (fishersCount <= 6) {
            discount = 0.10;
        } else if (fishersCount <= 11) {
            discount = 0.15;
        } else if (fishersCount > 12) {
            discount = 0.25;
        }
        double total = priceForBoat - (priceForBoat * discount);
        if (fishersCount % 2 == 0 && discountSeasons) {
            total = total - (total * 0.05);
        }
        double otherMoney = Math.abs(groupBudget - total);
        double neededMoney = Math.abs(groupBudget - total);
        if (groupBudget >= total) {
            System.out.printf("Yes! You have %.2f leva left.",otherMoney);
        } else if (total > groupBudget) {
            System.out.printf("Not enough money! You need %.2f leva.",neededMoney);
        }
    }
}
