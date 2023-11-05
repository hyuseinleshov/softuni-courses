package E02ConditionalStatements;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double timeInSecondsFor1meters = Double.parseDouble(scanner.nextLine());

        double needToSwim = distanceInMeters * timeInSecondsFor1meters;
        double delay = Math.floor(distanceInMeters / 15);
        double delayTime = delay * 12.5;

        double totalTime = needToSwim + delayTime;
        double neededSeconds = totalTime - recordInSeconds;

        if (totalTime < recordInSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",totalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.",neededSeconds);
        }
    }
}
