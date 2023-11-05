package Exersise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int targetsCount = 0;
        int originalPokePower = pokePower;

        while (pokePower >= distance) {
            pokePower = pokePower - distance;
            targetsCount++;

            if (pokePower == originalPokePower / 2 && exhaustionFactor != 0) {
                pokePower = pokePower / exhaustionFactor;
            }
        }
        System.out.printf("%d%n%d", pokePower, targetsCount);
    }
}
