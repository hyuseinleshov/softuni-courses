package Lab.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            int size = tokens.length;

            if (size == 3) {

                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Citizen citizen = new Citizen(name, age, id);

                identifiables.add(citizen);
            } else {

                String id = tokens[0];
                String model = tokens[1];

                Robot robot = new Robot(id, model);

                identifiables.add(robot);
            }

            input = scanner.nextLine();
        }

        String lastDigits = scanner.nextLine();

        identifiables.stream()
                .filter(i -> i.getId().endsWith(lastDigits))
                .forEach(i -> System.out.println(i.getId()));

    }

}
