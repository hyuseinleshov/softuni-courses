package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            if (!productQuantity.containsKey(product)) {
                productQuantity.put(product, quantity);
            } else {
                productQuantity.put(product, productQuantity.get(product) + quantity);
            }

            productPrice.put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productQuantity.entrySet()) {
            double sum = entry.getValue() * productPrice.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), sum);
        }
    }
}
