package Exercises.P05CarSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            int length = tokens.length;

            Engine engine = null;

            if (length == 2) {
                engine = new Engine(model, power);
            } else if (length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    int displacement = Integer.parseInt(tokens[2]);;

                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];

                    engine = new Engine(model, power, efficiency);
                }
            } else if (length == 4) {

                int displacement = Integer.parseInt(tokens[2]);;
                String efficiency = tokens[3];

                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.put(model, engine);

        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            String engineModel = tokens[1];

            Engine engine = engines.get(engineModel);

            Car car = null;

            int length = tokens.length;

            if (length == 2) {
                car = new Car(model, engine);
            } else if (length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {

                    int weight = Integer.parseInt(tokens[2]);

                    car = new Car(model, engine, weight);
                } else {

                    String color = tokens[2];

                    car = new Car(model, engine, color);
                }
            } else if (length == 4) {

                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                car = new Car(model, engine, weight, color);
            }

            cars.add(car);

        }

        cars.forEach(car -> System.out.println(car));

    }

}
