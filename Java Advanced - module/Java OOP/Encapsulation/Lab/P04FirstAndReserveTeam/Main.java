package Lab.P04FirstAndReserveTeam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Team team = new Team("Black Eagles");

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person player = new Person(firstName, lastName, age, salary);

            team.addPlayer(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");

    }

}
