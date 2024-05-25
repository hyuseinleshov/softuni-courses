package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolVolume = Integer.parseInt(scanner.nextLine());
        int waterPerHourFirstTube = Integer.parseInt(scanner.nextLine());
        int waterPerHourSecondTube = Integer.parseInt(scanner.nextLine());
        double workerAbsent = Double.parseDouble(scanner.nextLine());

        double firstTubeLitres = waterPerHourFirstTube * workerAbsent;
        double secondTubeLitres = waterPerHourSecondTube * workerAbsent;

        double totalLitres = firstTubeLitres + secondTubeLitres;
        double percent = (totalLitres / poolVolume) * 100;
        double firstTubePercent = (firstTubeLitres / totalLitres) * 100;
        double secondTubePercent = (secondTubeLitres / totalLitres) * 100;

        double excessLitres = totalLitres - poolVolume;

        if (poolVolume >= totalLitres) {
            System.out.printf("The pool is %.2f%% full.Pipe 1: %.2f%%.Pipe 2: %.2f%%.",percent,firstTubePercent,secondTubePercent);
        } else if (totalLitres > poolVolume) {
            System.out.printf("For %.2f " +
                    "hours the pool overflows with %.2f liters.",workerAbsent,excessLitres);
        }
    }
}
