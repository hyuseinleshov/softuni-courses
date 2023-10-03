package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> storeData = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);;

            if (!storeData.containsKey(shop)) {
                storeData.put(shop, new LinkedHashMap<>());
                storeData.get(shop).put(product, price);
            } else {
                storeData.get(shop).put(product, price);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : storeData.entrySet()) {
            System.out.println(shop.getKey() + "->");

            for (Map.Entry<String, Double> products : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", products.getKey(), products.getValue());
            }
        }
    }
}
