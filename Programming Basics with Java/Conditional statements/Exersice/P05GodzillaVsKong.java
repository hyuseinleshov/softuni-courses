package E02ConditionalStatements;

import java.util.Scanner;

public class P05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double filmBudget = Double.parseDouble(scanner.nextLine());
        int extrasNumber = Integer.parseInt(scanner.nextLine());
        double extrasClothingPrice = Double.parseDouble(scanner.nextLine());

        double decorPrice = filmBudget * 0.10;

        double clothingPrice = 0;
        if (extrasNumber > 150) {
            clothingPrice = (extrasNumber * extrasClothingPrice) - (extrasNumber * extrasClothingPrice) * 0.1;
        } else {
            clothingPrice = extrasNumber * extrasClothingPrice;
        }

        double totalPriceForDecorAndClothing = decorPrice + clothingPrice;
        double neededMoney = totalPriceForDecorAndClothing - filmBudget;
        double restMoney = filmBudget - totalPriceForDecorAndClothing;

        if (totalPriceForDecorAndClothing > filmBudget) {
            System.out.printf("Not enough money!%n");
            System.out.printf("Wingard needs %.2f leva more.",neededMoney);
        } else if (filmBudget >= totalPriceForDecorAndClothing) {
            System.out.printf("Action!%n");
            System.out.printf("Wingard starts filming with %.2f leva left.",restMoney);
        }
    }
}
