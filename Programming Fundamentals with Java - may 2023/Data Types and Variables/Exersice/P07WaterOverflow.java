package Exersise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int waterInTank = 0;
        int neededWater = 0;

        for (int i = 1; i <= n ; i++) {
            int quantitiesOfWater = Integer.parseInt(scanner.nextLine());
            neededWater = 255 - waterInTank;
            if (waterInTank < 255 && quantitiesOfWater <= neededWater) {
                waterInTank += quantitiesOfWater;
            }
            if (quantitiesOfWater > neededWater) {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(waterInTank);
    }
}
