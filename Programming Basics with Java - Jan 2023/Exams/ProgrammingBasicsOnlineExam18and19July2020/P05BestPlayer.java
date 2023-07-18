import java.util.Scanner;

public class P05BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int goals = Integer.parseInt(scanner.nextLine());

        String bestPlayer = "";
        int bestGoals = 0;
        boolean hatTrick = false;
        while (!input.equals("END")) {
            String name = input;
            if (goals > bestGoals) {
                bestGoals = goals;
                bestPlayer = name;
            }
            if (goals >= 3) {
                hatTrick = true;
            }
            if (goals >= 10) {
                break;
            }
            input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            goals = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("%s is the best player!%n",bestPlayer);
        if (hatTrick) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!",bestGoals);
        } else {
            System.out.printf("He has scored %d goals.",bestGoals);
        }
    }
}
