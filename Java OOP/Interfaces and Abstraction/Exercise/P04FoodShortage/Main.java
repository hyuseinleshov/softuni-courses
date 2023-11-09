package Exercise.P04FoodShortage;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> personMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            
            if (tokens.length == 3) {
                String group = tokens[2];

                Rebel rebel = new Rebel(name, age, group);

                personMap.put(name, rebel);
            } else if (tokens.length == 4) {
                String id = tokens[2];
                String birthdate = tokens[3];

                Citizen citizen = new Citizen(name, age, id, birthdate);

                personMap.put(name, citizen);
            }

        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String name = input;

            if (personMap.containsKey(name)) {
                personMap.get(name).buyFood();
            }

            input = scanner.nextLine();
        }

        int totalFood = 0;

        for (Map.Entry<String, Buyer> buyerEntry : personMap.entrySet()) {

            totalFood += buyerEntry.getValue().getFood();
        }

        System.out.println(totalFood);

    }

}
