package ForLoop_Exersise;

import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentsCount = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int points = 0;
        int winings = 0;

        for (int i = 1; i <= tournamentsCount ; i++) {
            String stage = scanner.nextLine();
            switch (stage) {
                case "W":
                    points = points + 2000;
                    winings+=1;
                    break;
                case "F":
                    points = points + 1200;
                    break;
                case "SF":
                    points = points + 720;
                    break;
            }
        }
        int finalPoints = points + startingPoints;
        int averagePoints = points / tournamentsCount;
        double percentWinings = (winings * 1.0 / tournamentsCount) * 100;

        System.out.printf("Final points: %d%n",finalPoints);
        System.out.printf("Average points: %d%n",averagePoints);
        System.out.printf("%.2f%%",percentWinings);
    }
}
