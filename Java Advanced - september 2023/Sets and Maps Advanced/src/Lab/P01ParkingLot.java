package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split(", ");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if ("IN".equals(direction)) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }
            command = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : carNumbers) {
                System.out.println(number);
            }
        }
    }
}
