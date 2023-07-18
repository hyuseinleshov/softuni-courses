package PBMoreE02ConditionalStatements;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int restDays = Integer.parseInt(scanner.nextLine());

        double restDaysPlay = restDays * 127;
        double workDaysPlay = (365 - restDays) * 63;
        double TomSleepNorm = 30000.0;
        double allPlayTime = restDaysPlay + workDaysPlay;
        double moreTime = TomSleepNorm - allPlayTime;
        double h1 = Math.floor(moreTime / 60);
        double m1 = moreTime % 60;
        double lessTime = allPlayTime - TomSleepNorm;
        double h2 = Math.floor(lessTime / 60);
        double m2 = lessTime % 60;

        if (allPlayTime > TomSleepNorm) {
            System.out.printf("Tom will run away%n");
            System.out.printf("%.0f hours and %.0f minutes more for play",h2,m2);
        } else if (allPlayTime < TomSleepNorm) {
            System.out.printf("Tom sleeps well%n");
            System.out.printf("%.0f hours and %.0f minutes less for play",h1,m1);
        }
    }
}
