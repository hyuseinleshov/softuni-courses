package WhileLoop_Exercise;

import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double instead = Double.parseDouble(scanner.nextLine());
        double insteadOnCoins = instead * 100;
        int insteadCounter = 0;

        while (true) {
            if (insteadOnCoins >= 200) {
                insteadOnCoins -= 200;
                insteadCounter++;
            } else if (insteadOnCoins >= 100) {
                insteadOnCoins -= 100;
                insteadCounter++;
            } else if (insteadOnCoins >= 50) {
                insteadOnCoins -= 50;
                insteadCounter++;
            } else if (insteadOnCoins >= 20) {
                insteadOnCoins -= 20;
                insteadCounter++;
            } else if (insteadOnCoins >= 10) {
                insteadOnCoins -= 10;
                insteadCounter++;
            } else if (insteadOnCoins >= 5) {
                insteadOnCoins -= 5;
                insteadCounter++;
            } else if (insteadOnCoins >= 2) {
                insteadOnCoins -= 2;
                insteadCounter++;
            } else if (insteadOnCoins >= 1) {
                insteadOnCoins -= 1;
                insteadCounter++;
            }
            if (insteadOnCoins <= 0.99) {
                break;
            }
        }
        System.out.println(insteadCounter);
    }
}
