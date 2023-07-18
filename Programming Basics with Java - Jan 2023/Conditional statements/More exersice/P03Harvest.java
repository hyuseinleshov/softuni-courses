package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vineyardM2 = Integer.parseInt(scanner.nextLine());
        double grapes = Double.parseDouble(scanner.nextLine());
        int neededVineLitres = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());

        double totalGrape = vineyardM2 * grapes;
        double vine = ((totalGrape * 0.40) / 2.5);

        double otherVine = Math.ceil(vine - neededVineLitres);
        double vineForOneWorker = Math.ceil(otherVine / workersCount);

        double neededVine = Math.floor(neededVineLitres - vine);

        if (vine >= neededVineLitres) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",vine);
            System.out.printf("%.0f liters left -> %.0f liters per person.",otherVine,vineForOneWorker);
        } else if (neededVineLitres > vine) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",neededVine);
        }
    }
}
