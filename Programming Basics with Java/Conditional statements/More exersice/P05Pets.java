package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P05Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double dogFood = Double.parseDouble(scanner.nextLine());
        double catFood = Double.parseDouble(scanner.nextLine());
        double turtleFood = Double.parseDouble(scanner.nextLine());

        double dogNeed = days * dogFood;
        double catNeed = days * catFood;
        double turtleNeed = (days * turtleFood) / 1000;

        double allFood = dogNeed + catNeed + turtleNeed;

        double leftFood = Math.floor(food - allFood);
        double neededFood = Math.ceil(allFood - food);

        if (food > allFood) {
            System.out.printf("%.0f kilos of food left.",leftFood);
        } else {
            System.out.printf("%.0f more kilos of food are needed.",neededFood);
        }
    }
}
