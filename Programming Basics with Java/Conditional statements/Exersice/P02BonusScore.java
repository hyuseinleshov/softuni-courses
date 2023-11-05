package E02ConditionalStatements;

import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingPoints = Integer.parseInt(scanner.nextLine());

        double bonusPoints = 0;

        if (startingPoints <= 100) {
            bonusPoints = 5;
        } else if (startingPoints > 1000) {
            bonusPoints = startingPoints * 0.10;
        } else {
            bonusPoints = startingPoints * 0.20;
        }
        if (startingPoints % 2 == 0){
            bonusPoints = bonusPoints + 1;
        } else if (startingPoints % 10 == 5) {
            bonusPoints = bonusPoints + 2;
        }
        System.out.println(bonusPoints);
        System.out.println(bonusPoints + startingPoints);
    }
}
