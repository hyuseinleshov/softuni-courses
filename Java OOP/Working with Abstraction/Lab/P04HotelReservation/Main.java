package Lab.P04HotelReservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discountType = tokens[3];

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);

        double totalPrice = priceCalculator.calculateTotalPrice();

        System.out.printf("%.2f", totalPrice);

    }

}
