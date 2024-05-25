package ForLoop_Exersise;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double startingPoints = Double.parseDouble(scanner.nextLine());
        int countJudges = Integer.parseInt(scanner.nextLine());

        double actorPoints = startingPoints;
        for (int i = 1; i <= countJudges ; i++) {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());
            actorPoints = (actorPoints + (judgeName.length() * judgePoints) / 2);
            if (actorPoints >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",actorName,actorPoints);
                break;
            }
        }
        double neededPoints = 1250.5 - actorPoints;
        if (actorPoints < 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!",actorName,neededPoints);
        }
    }
}
