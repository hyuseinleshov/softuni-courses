package Exercise.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> list = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split(" ");

            String type = tokens[0];

            if (type.equals("Citizen")) {

                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthdate = tokens[4];

                Citizen citizen = new Citizen(name, age, id, birthdate);

                list.add(citizen);
            } else if (type.equals("Pet")) {

                String name = tokens[1];
                String birthdate = tokens[2];

                Pet pet = new Pet(name, birthdate);

                list.add(pet);
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : list) {

            String currentBirthdate = birthable.getBirthDate();

            String[] tokens = currentBirthdate.split("/");
            String currentYear = tokens[2];

            if (currentYear.equals(year)) {

                System.out.println(birthable.getBirthDate());
            }
        }

    }

}
