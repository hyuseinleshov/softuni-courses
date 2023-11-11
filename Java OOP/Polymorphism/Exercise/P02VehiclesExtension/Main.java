package Exercise.P02VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String[] carTokens = scanner.nextLine().split("\\s+");

        double fuelQuantity = Double.parseDouble(carTokens[1]);
        double litresPerKm= Double.parseDouble(carTokens[2]);
        double tankCapacity = Double.parseDouble(carTokens[3]);

        Car car = new Car(fuelQuantity, litresPerKm, tankCapacity);

        String[] truckTokens = scanner.nextLine().split("\\s+");

        double fuelQuantity2 = Double.parseDouble(truckTokens[1]);
        double litresPerKm2 = Double.parseDouble(truckTokens[2]);
        double tankCapacity2 = Double.parseDouble(truckTokens[3]);

        Truck truck = new Truck(fuelQuantity2, litresPerKm2, tankCapacity2);

        String[] busTokens = scanner.nextLine().split("\\s+");

        double fuelQuantity3 = Double.parseDouble(busTokens[1]);
        double litresPerKm3= Double.parseDouble(busTokens[2]);
        double tankCapacity3 = Double.parseDouble(busTokens[3]);

        Bus bus = new Bus(fuelQuantity3, litresPerKm3, tankCapacity3);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String typeCommand = tokens[0];
            String typeVehicle = tokens[1];

            boolean isComplete = true;

            switch (typeCommand) {

                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);

                    if (typeVehicle.equals("Car")) {

                        isComplete = car.drive(distance);
                    } else if (typeVehicle.equals("Truck")) {

                        isComplete = truck.drive(distance);
                    } else if (typeVehicle.equals("Bus")) {

                        isComplete = bus.drive(distance, true);
                    }

                    if (isComplete) {

                        System.out.printf("%s travelled %s km\n", typeVehicle, decimalFormat.format(distance));
                    } else {

                        System.out.printf("%s needs refueling\n", typeVehicle);
                    }
                    break;
                case "Refuel":
                    double litres = Double.parseDouble(tokens[2]);

                    if (typeVehicle.equals("Car")) {

                        car.refuel(litres);
                    } else if (typeVehicle.equals("Truck")) {

                        truck.refuel(litres);
                    } else if (typeVehicle.equals("Bus")) {

                        bus.refuel(litres);
                    }

                    break;
                case "DriveEmpty":
                    double km = Double.parseDouble(tokens[2]);

                    isComplete = bus.drive(km, false);

                    if (isComplete) {

                        System.out.printf("%s travelled %s km\n", typeVehicle, decimalFormat.format(km));
                    } else {

                        System.out.printf("%s needs refueling\n", typeVehicle);
                    }

                    break;
            }

        }

        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f\n", bus.getFuelQuantity());

    }

}
