package E02ConditionalStatements;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int serialTime = Integer.parseInt(scanner.nextLine());
        int restDuration = Integer.parseInt(scanner.nextLine());;

        double lunchTime = restDuration * 0.125;
        double rest = restDuration * 0.25;

        double otherTime = restDuration - lunchTime - rest;
        double freeTime = Math.ceil(otherTime - serialTime);
        double neededTime = Math.ceil(serialTime - otherTime);

        if (otherTime >=serialTime) {
            System.out.printf("You have enough time to watch %s " +
                    "and left with %.0f minutes free time.",serialName,freeTime);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",serialName,neededTime);
        }
    }
}
