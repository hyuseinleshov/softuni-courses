package Exercises.P04RawData;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Set<Car>> carsType = new LinkedHashMap<>();

        carsType.put("fragile", new LinkedHashSet<>());
        carsType.put("flamable", new LinkedHashSet<>());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age}
            // {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}"

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tire[] tires = new Tire[4];

            boolean isFragile = false;

            for (int j = 5; j <= 11; j += 2) {

                double currentTirePressure = Double.parseDouble(tokens[j]);

                if (currentTirePressure < 1) {
                    isFragile = true;
                }

                        int currentTireAge = Integer.parseInt(tokens[j + 1]);
            }

            Car car = new Car(model, engine, cargo, tires);

            if (isFragile) {
                carsType.get("fragile").add(car);
            } else if (enginePower > 230) {
                carsType.get("flamable").add(car);
            }
        }

        String type = scanner.nextLine();

        Set<Car> neededCars = carsType.get(type);

        for (Car car : neededCars) {
            System.out.println(car.getModel());
        }

    }

}
