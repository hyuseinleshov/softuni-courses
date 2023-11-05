package Exercise.P05VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehiclesList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] vehicleDataArray = input.split(" ");
            String typeOfVehicle = vehicleDataArray[0];
            String model = vehicleDataArray[1];
            String color = vehicleDataArray[2];
            int horsepower = Integer.parseInt(vehicleDataArray[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehiclesList.add(vehicle);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("Close the Catalogue")) {
            for (int i = 0; i < vehiclesList.size(); i++) {
                if (vehiclesList.get(i).getModel().equals(input2)) {
                    if (vehiclesList.get(i).getTypeOfVehicle().equals("car")) {
                        System.out.println("Type: Car");
                    } else {
                        System.out.println("Type: Truck");
                    }
                    System.out.printf("Model: %s%n", vehiclesList.get(i).getModel());
                    System.out.printf("Color: %s%n", vehiclesList.get(i).getColor());
                    System.out.printf("Horsepower: %s%n", vehiclesList.get(i).getHorsepower());
                    input2 = scanner.nextLine();
                }
            }
        }
        double carsHorsepowerSum = 0;
        double trucksHorsepowerSum = 0;
        int carsCount = 0;
        int trucksCount = 0;
        for (int i = 0; i < vehiclesList.size(); i++) {
            if (vehiclesList.get(i).getTypeOfVehicle().equals("car")) {
                carsHorsepowerSum += vehiclesList.get(i).getHorsepower();
                carsCount++;
            } else {
                trucksHorsepowerSum += vehiclesList.get(i).getHorsepower();
                trucksCount++;
            }
        }
        double carsAverageHorsepower = 0;
        double trucksAverageHorsepower = 0;
        if (carsCount == 0) {

        } else {
            carsAverageHorsepower = carsHorsepowerSum / carsCount;
        }
        if (trucksCount == 0) {

        } else {
            trucksAverageHorsepower = trucksHorsepowerSum / trucksCount;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverageHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksAverageHorsepower);
    }
}
